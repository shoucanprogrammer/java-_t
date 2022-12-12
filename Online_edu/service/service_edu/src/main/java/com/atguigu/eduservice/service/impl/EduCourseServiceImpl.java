package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.*;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-17
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    //课程描述方法注入
    @Autowired
    private EduCourseDescriptionService courseDescriptionService;
    @Autowired
    private EduChapterService chapterService;
    @Autowired
    private EduVideoService videoService;

    @Autowired
    private VodClient vodClient;

    @Override
    public String save(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        eduCourse.setStatus(EduCourse.COURSE_DRAFT);
        int insertResult = baseMapper.insert(eduCourse);
        if (insertResult == 0){
            throw new GuliException(20001,"添加失败");

        }        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        //获取eduCourse自动生成的id
        String id = eduCourse.getId();
        BeanUtils.copyProperties(courseInfoVo,eduCourseDescription);
        //确保id对应
        eduCourseDescription.setId(id);
        boolean saveResult = courseDescriptionService.save(eduCourseDescription);
        if (!saveResult){
            throw new GuliException(20001,"添加失败");
        }
        return eduCourse.getId();
    }

    @Override
    public CourseInfoVo getCourseInfoById(String courseId) {
        //查询课程基本信息
        EduCourse eduCourse = baseMapper.selectById(courseId);
        if (eduCourse == null){
            throw new GuliException(20001,"查询失败");
        }
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse,courseInfoVo);
        //查询课程描述

        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);

        BeanUtils.copyProperties(courseDescription,courseInfoVo);
        if (courseDescription== null){
            throw new GuliException(20001,"查询失败");
        }
        return courseInfoVo;
    }

    @Override
    @Transactional
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int i = baseMapper.updateById(eduCourse);
        if (i == 0){
            throw  new GuliException(20001,"修改失败");
        }
        EduCourseDescription courseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo,courseDescription);
        boolean b = courseDescriptionService.updateById(courseDescription);

    }

    @Override
    public CoursePublishVo publishCourseInfo(String id) {
         return baseMapper.getCoursePublishVoById(id);
        }

    @Override
    public Boolean removeCourse(String courseId) {

        //删除小节(包含视频)
        videoService.removeByCouseId(courseId);

        //删除章节
        QueryWrapper<EduChapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id",courseId);
        chapterService.remove(chapterQueryWrapper);
        //删除课程描述
        QueryWrapper<EduCourseDescription> courseDescriptionQueryWrapper = new QueryWrapper<>();
        courseDescriptionService.remove(courseDescriptionQueryWrapper);

        //删除课程
        int i = baseMapper.deleteById(courseId);
        return i>0;
    }
}
