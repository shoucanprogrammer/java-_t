package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.frontvo.CourseWebVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-11-17
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    CoursePublishVo selectCoursePublishVoById(String id);

    CoursePublishVo getCoursePublishVoById(String id);

    CourseWebVo getBaseCourseInfo(String courseId);
}
