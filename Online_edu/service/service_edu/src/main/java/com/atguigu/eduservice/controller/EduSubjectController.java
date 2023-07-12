package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-11-16
 */
@RestController
//@CrossOrigin
@RequestMapping("/eduservice/subject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    @PostMapping("addSubject")
    public R addSubject(MultipartFile multipartFile){
        //上传过来的excel文件
        subjectService.save(multipartFile,subjectService);
        return R.ok();

    }
    //课程分类列表(树形)
    @ApiOperation(value = "//课程分类列表(树形)")
    @GetMapping("getAllSubject")
    public R getAllSubject(){
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }

}

