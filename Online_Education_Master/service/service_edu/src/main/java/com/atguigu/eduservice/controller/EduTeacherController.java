package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;

import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-11-05
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    //访问地址： http://localhost:8001/eduservice/teacher/findAll
    //把service注入
    @Autowired
    private EduTeacherService teacherService;

    //1 查询讲师表所有风格
    //rest风格
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        //调用service的方法实现查询的所有操作

        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }
    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name="id",value = "讲师ID",required = true)
            @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
    @ApiOperation(value = "分页查询讲师")
    //分页查询讲师的方法
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable Integer current,
                             @PathVariable Integer limit){
        //创建page对象
        Page<EduTeacher> PageTeacher = new Page<>(current,limit);
        try {
            int i = 10/0;
        }catch (Exception e){
            throw new GuliException(20001,"执行了自定义异常");
        }


        teacherService.page(PageTeacher, null);//数据list集合
        List<EduTeacher> records = PageTeacher.getRecords();
        long total = PageTeacher.getTotal();;
//        Map map = new HashMap();
//        map.put("total",total);
//        map.put("row",records);
//        return R.ok().data(map);
        return R.ok().data("total",total).data("rows",records);
    }

    //条件查询带分页的方法
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        //多条件组合查询
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.like("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.like("gmt_create",end);
        }

        //调用方法实现分页操作
        teacherService.page(pageTeacher, wrapper);
        List<EduTeacher> records = pageTeacher.getRecords();
        Long total = pageTeacher.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else {
            return  R.error();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

    //讲师修改功能
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }

    }
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("updateTeacher")
    public R updateById(
//            @ApiParam(name = "id", value = "讲师ID", required = true)
//    @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
    @RequestBody(required = false) EduTeacher eduTeacher){
//        eduTeacher.setId(id);
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
//    @DeleteMapping("{id}")
//    public R removeById(
//            @ApiParam(name ="id" ,value = "讲师ID",required = true)
//            @PathVariable String id){
//        boolean result = teacherService.removeById(id);
//        if (result){
//            return R.ok().message("删除成功");
//        }else {
//            return R.error().message("删除失败");
//        }
//
//    }

}

