package com.tl.dianping.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.dianping.dto.Result;
import com.tl.dianping.dto.UserDTO;
import com.tl.dianping.entity.Follow;
import com.tl.dianping.entity.User;
import com.tl.dianping.mapper.FollowMapper;
import com.tl.dianping.service.IFollowService;
import com.tl.dianping.service.IUserService;
import com.tl.dianping.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private IUserService userService;

    @Override
    public Result follow(Long followUserId, Boolean isFollow) {
        //获取当前登录对象id
        Long userId = UserHolder.getUser().getId();
        String key = "follows:" + userId;
        if (isFollow){
            //关注 新增信息
            Follow follow = new Follow();
            follow.setUserId(userId);
            follow.setFollowUserId(followUserId);
            boolean isSuccess = save(follow);
            if (isSuccess){
                stringRedisTemplate.opsForSet().add(key,followUserId.toString());
            }
        }else {
            //取消关注 删除信息
           QueryWrapper<Follow> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId);
            wrapper.eq("follow_user_id",followUserId);
            boolean isSuccess = remove(wrapper);
            if (isSuccess){
                stringRedisTemplate.opsForSet().remove(key,followUserId.toString());
            }
        }
        return Result.ok();
    }

    @Override
    public Result isFollow(Long followUserId) {
        //获取当前登录对象id
        Long userId = UserHolder.getUser().getId();
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("follow_user_id",followUserId);
        Integer count = baseMapper.selectCount(wrapper);
        return Result.ok(count > 0);
    }

    @Override
    public Result followCommons(Long id) {
        //获取当前用户
        Long userId = UserHolder.getUser().getId();
        String key = "follows" + userId;
      //求交集
        String key2 = "follows" + id;
        Set<String> intersect = stringRedisTemplate.opsForSet().intersect(key, key2);
        if (intersect == null && intersect.isEmpty()){
            return Result.ok(Collections.emptyList());
        }
        //解析id集合
        List<Long> ids = intersect.stream().map(Long::valueOf).collect(Collectors.toList());
        List<UserDTO> userDTOS = userService.listByIds(ids).stream().map(user -> BeanUtil.copyProperties(user, UserDTO.class)).collect(Collectors.toList());
        return Result.ok(userDTOS);
    }
}
