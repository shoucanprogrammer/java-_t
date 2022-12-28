package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.frontvo.CourseFrontVo;
import com.atguigu.eduservice.entity.frontvo.CourseWebVo;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-11-17
 */
public interface EduCourseService extends IService<EduCourse> {

    String save(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfoById(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);



    CoursePublishVo publishCourseInfo(String id);


    Boolean removeCourse(String courseId);


    Map<String, Object> getFrontCourseList(Page<EduCourse> eduCoursePage, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
