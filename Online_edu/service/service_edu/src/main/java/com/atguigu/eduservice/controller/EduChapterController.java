package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.impl.EduChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-11-17
 */
@RestController
//@CrossOrigin
@RequestMapping("/eduservice/chapter")
public class EduChapterController {
    @Autowired
    private EduChapterService chapterService;

    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> chapterVideoByCourseId = chapterService.getChapterVideoByCourseId(courseId);

        return R.ok().data("allChapterVideo",chapterVideoByCourseId);
    }
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        boolean save = chapterService.save(eduChapter);
        return  R.ok();
    }

    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapter(@PathVariable String chapterId){
        EduChapter eduChapter = chapterService.getById(chapterId);
        return R.ok().data("chapter",eduChapter);
    }

    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        chapterService.updateById(eduChapter);
        return R.ok();
    }

    @DeleteMapping("{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
        boolean flag = chapterService.deleteChapter(chapterId);
        if (flag){
            return R.ok();
        }else {
            return  R.error();
        }

    }


}

