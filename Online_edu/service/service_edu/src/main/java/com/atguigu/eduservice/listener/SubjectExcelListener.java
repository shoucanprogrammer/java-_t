package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;

import java.util.Map;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    //因为SubjectExcelListener不能交给Spring进行管理，需要自己new，不能注入其他对象
    //不能实现库操作
    public EduSubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null){
            throw new GuliException(2001,"文件数据为空");
        }
        //一行一行读取，每次读取两个值，第一个值一级分类，第二个值二级分类
        EduSubject existOneSubject = this.existOneSubject(subjectService, subjectData.getOneSubjectName());
        //判断一级分类不能重复添加
        if (existOneSubject == null){
            EduSubject eduSubject = new EduSubject();
            eduSubject.setParentId("0");
            eduSubject.setTitle(subjectData.getOneSubjectName());
            subjectService.save(eduSubject);
        }

        String parent_id = existOneSubject.getId();
        //添加二级分类
        //判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(subjectService, subjectData.getTwoSubjectName(), parent_id);
        if (existTwoSubject == null){
            EduSubject eduSubject = new EduSubject();
            eduSubject.setParentId(parent_id);
            eduSubject.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(eduSubject);
        }
    }


    private EduSubject existOneSubject(EduSubjectService subjectService,String name){
        QueryWrapper<EduSubject> wapper = new QueryWrapper<>();
        wapper.eq("title",name);
        wapper.eq("parent_id","0");
        EduSubject oneSubject = subjectService.getOne(wapper);
        return oneSubject;
    }
    //判断一级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService subjectService,String name,String parent_id){
        QueryWrapper<EduSubject> wapper = new QueryWrapper<>();
        wapper.eq("title",name);
        wapper.eq("parent_id",parent_id);
        EduSubject twoSubject = subjectService.getOne(wapper);
        return twoSubject;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头:"+headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
