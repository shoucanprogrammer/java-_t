package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.entity.subject.TwoSubject;
import com.atguigu.eduservice.listener.SubjectExcelListener;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-16
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void save(MultipartFile multipartFile, EduSubjectService subjectService) {
        try {
            InputStream is = multipartFile.getInputStream();
            EasyExcel.read(is,SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //查一级科目
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id","0");
        List<EduSubject> oneEduSubjects = baseMapper.selectList(wrapperOne);

        //查二级科目
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0");
        List<EduSubject> twoEduSubjects = baseMapper.selectList(wrapperTwo);

        //封装列表
        List<OneSubject> finalSubjectList = new ArrayList<>();
        //遍历一级科目
        for (int i = 0; i < oneEduSubjects.size(); i++){
            EduSubject eduSubject = oneEduSubjects.get(i);
            OneSubject oneSubject = new OneSubject();
            //记下二级科目的父id便于查找
            String pid = eduSubject.getId();
            oneSubject.setId(eduSubject.getId());
            oneSubject.setTitle(eduSubject.getTitle());

//            使用工具写法
//            BeanUtils.copyProperties(eduSubject,oneSubject);
            //封装一级分类，链表是地址可以先封装
            finalSubjectList.add(oneSubject);

            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            //遍历二级科目
            for (int j = 0; j < twoEduSubjects.size(); j++){
                EduSubject twoEduSubject = twoEduSubjects.get(j);
                if (twoEduSubject.getParentId().equals(pid)){
                    TwoSubject twoSubject = new TwoSubject();
                    twoSubject.setId(twoEduSubject.getId());
                    twoSubject.setTitle(twoEduSubject.getTitle());
                    twoFinalSubjectList.add(twoSubject);
                }

            }
            oneSubject.setChildren(twoFinalSubjectList);


        }

        return finalSubjectList;

    }
}
