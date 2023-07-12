package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-11-17
 */
@RestController
//@CrossOrigin
@RequestMapping("/eduservice/video")
public class EduVideoController {
    @Autowired
    private EduVideoService videoService;
    @Autowired VodClient vodClient;
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo video){
        videoService.save(video);
        return R.ok();
    }

    @DeleteMapping("{videoId}")
    public R deleteVideo(@PathVariable String videoId){
        EduVideo eduVideo = videoService.getById(videoId);
        String videoSourceId = eduVideo.getVideoSourceId();
        if (!StringUtils.isEmpty(videoSourceId)){
            R r = vodClient.removeAlyVideo(videoSourceId);
            if (r.getCode()==20001){
                throw new GuliException(20001,"删除失败");
            }
        }
        boolean b = videoService.removeById(videoId);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @PostMapping("updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        boolean b = videoService.updateById(eduVideo);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

