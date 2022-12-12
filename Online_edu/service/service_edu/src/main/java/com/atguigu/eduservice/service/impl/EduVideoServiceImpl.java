package com.atguigu.eduservice.service.impl;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.mapper.EduVideoMapper;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-17
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {
    @Autowired
    private VodClient vodClient;
    @Override
    public void removeByCouseId(String courseId) {
        //先删除视频
        QueryWrapper<EduVideo> videosWrapper = new QueryWrapper<>();
        videosWrapper.eq("course_id",courseId);
        List<EduVideo> videos = baseMapper.selectList(videosWrapper);
        //定义videoIds列表
        List<String> videoIds = new ArrayList<>();
        for (int i = 0; i < videos.size(); i++){
            EduVideo eduVideo = videos.get(i);
            String videoSourceId = eduVideo.getVideoSourceId();
            if (!StringUtils.isEmpty(videoSourceId)){
                videoIds.add(videoSourceId);
            }
        }
        R r = vodClient.deleteBatch(videoIds);
        if (r.getCode()==200001){
            throw new GuliException(20001,"删除失败");
        }
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);



    }
}
