package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.entity.chapter.VideoVo;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Autowired
    private EduVideoService videoService;
    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper();
        wrapper.eq("course_id",courseId);
        List<EduChapter> listChapter = baseMapper.selectList(wrapper);

        ArrayList<ChapterVo> chapterVos = new ArrayList<>();
        for (int i = 0; i < listChapter.size(); i++){
            EduChapter eduChapter = new EduChapter();
            eduChapter =listChapter.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter,chapterVo);

            //封装Chapter
            chapterVos.add(chapterVo);

            //查询该Chapter下的Video
            QueryWrapper<EduVideo> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("course_id",courseId);
            wrapper1.eq("chapter_id",eduChapter.getId());
            List<EduVideo> listVideo = videoService.list(wrapper1);

            ArrayList<VideoVo> videoVos = new ArrayList<>();

            for (int j = 0; j < listVideo.size(); j++){
                EduVideo eduVideo = listVideo.get(j);
                VideoVo videoVo = new VideoVo();
                BeanUtils.copyProperties(eduVideo,videoVo);
                //封装video
                videoVos.add(videoVo);
            }
            //一二级组装封装
            chapterVo.setChildren(videoVos);
        }
        return chapterVos;
    }

    @Override
    public boolean deleteChapter(String chapterId) {

        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id",chapterId);
        int count = videoService.count(wrapper);
        if (count>0){
            throw new GuliException(20001,"不能删除");
        }else {
            int i = baseMapper.deleteById(chapterId);
            return i > 0;
        }
    }
}
