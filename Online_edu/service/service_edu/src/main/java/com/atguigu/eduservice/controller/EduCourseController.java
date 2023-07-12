package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/eduservice/course")
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @GetMapping
    public R getAll(){
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("list",list);
    }

    //删除课程
    @DeleteMapping("{id}")
//    @GetMapping("{id}")
//    @DeleteMapping("{id}")
    public R deleteCourse(@PathVariable String id){
        Boolean flag = courseService.removeCourse(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @GetMapping("pageCourse/{current}/{limit}")
    public R pageCourse(@PathVariable Integer current, @PathVariable Integer limit){
        Page<EduCourse> coursePage = new Page<>(current,limit);
        courseService.page(coursePage,null);
        long total = coursePage.getTotal();
        List<EduCourse> records = coursePage.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    @GetMapping("pageCourseCondition/{current}/{limit}")
    public R pageCourseCondition(@PathVariable Integer current,
                                 @PathVariable Integer limit
    ){
        Page<EduCourse> coursePage = new Page<>(current,limit);
        courseService.page(coursePage,null);
        long total = coursePage.getTotal();
        List<EduCourse> records = coursePage.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String courseId = courseService.save(courseInfoVo);
        if (StringUtils.isEmpty(courseId))
        {
            return R.error().message("保存失败");
        }
        return R.ok().data("courseId",courseId);
    }

    //查询课程基本信息的方法
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = courseService.getCourseInfoById(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    //查询课程基本信息的方法
    @PostMapping("updateCourseInfo")
    public R getCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }


    //根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return R.ok().data("publishCourse",coursePublishVo);
    }
    //最终发布
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse course = new EduCourse();
        course.setId(id);
        course.setStatus("Normal");
        courseService.updateById(course);
        return R.ok();
    }


}

