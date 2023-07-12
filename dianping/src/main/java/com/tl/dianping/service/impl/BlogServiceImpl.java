package com.tl.dianping.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.dianping.dto.Result;
import com.tl.dianping.dto.ScrollResult;
import com.tl.dianping.dto.UserDTO;
import com.tl.dianping.entity.Blog;
import com.tl.dianping.entity.Follow;
import com.tl.dianping.entity.User;
import com.tl.dianping.mapper.BlogMapper;
import com.tl.dianping.service.IBlogService;
import com.tl.dianping.service.IFollowService;
import com.tl.dianping.service.IUserService;
import com.tl.dianping.utils.SystemConstants;
import com.tl.dianping.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tl.dianping.utils.RedisConstants.BLOG_LIKED_KEY;
import static com.tl.dianping.utils.RedisConstants.FEED_KEY;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Resource
    private IUserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IFollowService followService;

    @Override
    public Result queryHotBlog(Integer current) {
        // 根据用户查询
        Page<Blog> page = query()
                .orderByDesc("liked")
                .page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        // 获取当前页数据
        List<Blog> records = page.getRecords();
        // 查询用户
        records.forEach(blog -> {
            this.queryBlogUser(blog);
            this.isBlogLiked(blog);
        });
        return Result.ok(records);
    }

    @Override
    public Result queryBlogById(Long id) {
        // 1.查询blog
        Blog blog = getById(id);
        if (blog == null) {
            return Result.fail("笔记不存在！");
        }
        // 2.查询blog有关的用户
        queryBlogUser(blog);
        // 3.查询blog是否被点赞
        isBlogLiked(blog);
        return Result.ok(blog);
    }

    private void isBlogLiked(Blog blog) {
        // 1.获取登录用户
        UserDTO user = UserHolder.getUser();
        if (user == null) {
            // 用户未登录，无需查询是否点赞
            return;
        }
        Long userId = user.getId();
        // 2.判断当前登录用户是否已经点赞
        String key = "blog:liked:" + blog.getId();
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        blog.setIsLike(score != null);
    }

    @Override
    public Result likeBlog(Long id) {
        // 1.获取登录用户
        Long userId = UserHolder.getUser().getId();
        // 2.判断当前登录用户是否已经点赞
        String key = BLOG_LIKED_KEY + id;
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        if (score == null) {
            // 3.如果未点赞，可以点赞
            // 3.1.数据库点赞数 + 1
            boolean isSuccess = update().setSql("liked = liked + 1").eq("id", id).update();
            // 3.2.保存用户到Redis的set集合  zadd key value score
            if (isSuccess) {
                stringRedisTemplate.opsForZSet().add(key, userId.toString(), System.currentTimeMillis());
            }
        } else {
            // 4.如果已点赞，取消点赞
            // 4.1.数据库点赞数 -1
            boolean isSuccess = update().setSql("liked = liked - 1").eq("id", id).update();
            // 4.2.把用户从Redis的set集合移除
            if (isSuccess) {
                stringRedisTemplate.opsForZSet().remove(key, userId.toString());
            }
        }
        return Result.ok();
    }

    @Override
    public Result queryBlogLikes(Long id) {
        String key = BLOG_LIKED_KEY + id;
        // 1.查询top5的点赞用户 zrange key 0 4
        Set<String> top5 = stringRedisTemplate.opsForZSet().range(key, 0, 4);
        if (top5 == null || top5.isEmpty()) {
            return Result.ok(Collections.emptyList());
        }
        // 2.解析出其中的用户id
        List<Long> ids = top5.stream().map(Long::valueOf).collect(Collectors.toList());
        String idStr = StrUtil.join(",", ids);
        // 3.根据用户id查询用户 WHERE id IN ( 5 , 1 ) ORDER BY FIELD(id, 5, 1)
        List<UserDTO> userDTOS = userService.query()
                .in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list()
                .stream()
                .map(user -> BeanUtil.copyProperties(user, UserDTO.class))
                .collect(Collectors.toList());
        // 4.返回
        return Result.ok(userDTOS);
    }

    @Override
    public Result saveBlog(Blog blog) {
        //1 获取登录用户
        UserDTO user = UserHolder.getUser();
        blog.setUserId(user.getId());
        //2保存探店笔记
        boolean isSuccess = save(blog);
        if (!isSuccess){
            return Result.fail("新增笔记失败");
        }
        //3查询笔记作者的所有粉丝 select * from tb_follow where follow_user_id = ?
        List<Follow> follows = followService.query().eq("follow_user_id",user.getId()).list();
        //推送笔记id刚给所有粉丝
        for (Follow follow : follows){
            //4.1 获取粉丝id
            Long userId = follow.getUserId();
            //4.2 推送
            String key = "feed:" + userId;
            stringRedisTemplate.opsForZSet().add(key,blog.getId().toString(),System.currentTimeMillis());
        }
        //5返回id
        return  Result.ok(blog.getId());
    }

    @Override
    public Result queryBlogOfFollow(Long max, Integer offset) {
        //1 获取当前用户
        Long userId = UserHolder.getUser().getId();
        //2 查询收件箱 ZREVRANGEBYSCORE key Max Min  LIMIT offset count
        String key = "feed:" + userId;
        Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.
                opsForZSet().reverseRangeByScoreWithScores
                        (key, 0.0, max, offset, 2);
        //3 非空判断
        if (typedTuples == null || typedTuples.isEmpty()){
            return Result.ok();
        }
        //4 解析数据：blogId,score minTime(时间戳),offset
        List<Long> ids = new ArrayList<>(typedTuples.size());
        long minTime = 0;
        int num = 1;
        for (ZSetOperations.TypedTuple<String> tuple : typedTuples){
            //4.1 获取id
            String idStr = tuple.getValue();
            ids.add(Long.valueOf(idStr));
            //4.2 获取分数（时间戳）
            long time = tuple.getScore().longValue();
            if (time == minTime){
                num ++;
            }else {
                minTime = time;
                num = 1;
            }
        }
        //4 根据id查询blog
        String idStr = StrUtil.join(",",ids);
        List<Blog> blogs = query().in("id",ids).last("ORDER BY FIELD(id,"+idStr+")").list();
        //给博客添加发表信息，点赞信息
        for (Blog blog : blogs){
            //5.1 查询blog有关的用户
            queryBlogUser(blog);
            //5.2 查询blog是否背点赞
            isBlogLiked(blog);
        }
        //5 封装并返回
        ScrollResult r = new ScrollResult();

        r.setList(blogs);
        r.setMinTime(minTime);
        r.setOffset(num);
        return Result.ok(r);
    }

    private void  queryBlogUser(Blog blog) {
        Long userId = blog.getUserId();
        User user = userService.getById(userId);
        blog.setName(user.getNickName());
        blog.setIcon(user.getIcon());
    }
}
