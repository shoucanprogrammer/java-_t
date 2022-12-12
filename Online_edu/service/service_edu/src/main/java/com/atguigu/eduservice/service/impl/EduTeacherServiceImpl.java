package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.listener.SubjectExcelListener;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-14
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    //添加课程分类
    @Override
    public void saveSubject(MultipartFile multipartFile){
        try {
            InputStream is = multipartFile.getInputStream();
            //调用函数进行读取
            EasyExcel.read(is,SubjectData.class,new SubjectExcelListener()).sheet().doRead();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
