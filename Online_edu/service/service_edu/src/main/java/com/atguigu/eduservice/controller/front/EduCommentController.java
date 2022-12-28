package com.atguigu.eduservice.controller.front;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.CommentClient;
import com.atguigu.eduservice.entity.EduComment;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.service.EduCommentService;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/eduservice/educomment")
public class EduCommentController {
    @Autowired
    private EduCommentService commentService;
    @Autowired
    private CommentClient commentClient;

    @PostMapping("/saveComment/{courseid}/{teacherid}/{comment}")
    public R SaveComment(@PathVariable String courseid, @PathVariable String teacherid,
                         @PathVariable String comment, HttpServletRequest request){
        Map<String, String> memberInfo1 = commentClient.getMemberInfo1(request);
        EduComment eduComment = new EduComment();
        eduComment.setCourseId(courseid);
        eduComment.setTeacherId(teacherid);
        eduComment.setContent(comment);
        eduComment.setMemberId(memberInfo1.get("Id"));
        eduComment.setAvatar(memberInfo1.get("Avatar"));
        eduComment.setNickname(memberInfo1.get("Nickname"));
        commentService.save(eduComment);
        return R.ok();

    }

    @GetMapping("pageCommentCondition/{current}/{limit}")
    public R pageCourseCondition(@PathVariable Integer current,
                                 @PathVariable Integer limit
    ){
        Page<EduComment> commentPage = new Page<>(current,limit);
        commentService.page(commentPage,null);
        long total = commentPage.getTotal();
        List<EduComment> records = commentPage.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }


}

