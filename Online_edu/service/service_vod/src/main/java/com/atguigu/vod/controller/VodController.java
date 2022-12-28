package com.atguigu.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.atguigu.commonutils.R;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVodUtils;
import com.atguigu.vod.utils.InitObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {
    @Autowired
    private VodService vodService;

    @PostMapping("uploadAlyiVideo")
    public R uploadAlyiVideo(MultipartFile file){
        String videoId = vodService.uploadAlyiVideo(file);
        return R.ok().data("videoId",videoId);
    }

    @DeleteMapping("removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable String id){
        vodService.removeAlyiVideo(id);
        return R.ok();
//        try {
//            //初始化对象
//            DefaultAcsClient client = InitObject.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
//            //创建删除视频request对象
//            DeleteVideoRequest request = new DeleteVideoRequest();
//            //向request设置视频id
//            request.setVideoIds(id);
//            //调用初始化对象的方法实现删除
//            DeleteVideoResponse acsResponse = client.getAcsResponse(request);
//            System.out.println(acsResponse);
//            return R.ok();
//        }catch(Exception e) {
//            e.printStackTrace();
//            throw new GuliException(20001,"删除视频失败");
//        }
    }
    @DeleteMapping("delete-batch")
    public R deleteBatch(@RequestParam List<String> videoIdList){
        vodService.deleteBatch(videoIdList);
        return R.ok();
    }
    //根据视频id获取视频凭证
    @GetMapping("getPlayAuth/{id}")
    public R getPlayAuth(@PathVariable String id) {
        try {
            //创建初始化对象
            DefaultAcsClient client =
                    InitObject.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            //创建获取凭证request和response对象
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            //向request设置视频id
            request.setVideoId(id);
            //调用方法得到凭证
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            return R.ok().data("playAuth",playAuth);
        }catch(Exception e) {
            throw new GuliException(20001,"获取凭证失败");
        }
    }

}
