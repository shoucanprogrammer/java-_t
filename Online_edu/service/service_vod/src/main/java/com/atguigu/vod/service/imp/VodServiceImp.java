package com.atguigu.vod.service.imp;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.InitObject;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

import static com.atguigu.vod.utils.ConstantVodUtils.ACCESS_KEY_ID;
import static com.atguigu.vod.utils.ConstantVodUtils.ACCESS_KEY_SECRET;
import static com.atguigu.vod.utils.InitObject.initVodClient;

@Service
public class VodServiceImp implements VodService {
    @Override
    public String uploadAlyiVideo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String title = fileName.substring(0,fileName.lastIndexOf('.'));
        System.out.println(fileName);
        System.out.println(title);  //fileName 除掉后缀
        System.out.println(ACCESS_KEY_ID);
        System.out.println(ACCESS_KEY_SECRET);
        //上传视频的方法
        UploadVideoRequest request = new UploadVideoRequest(ACCESS_KEY_ID, ACCESS_KEY_SECRET, title, fileName);
        /* 可指定分片上传时每个分片的大小，默认为2M字节 */
        request.setPartSize(2 * 1024 * 1024L);
        /* 可指定分片上传时的并发线程数，默认为1，(注：该配置会占用服务器CPU资源，需根据服务器情况指定）*/
        request.setTaskNum(5);

        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);
        String videoId;
        if (response.isSuccess()) {
            videoId = response.getVideoId();
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            videoId = response.getVideoId();
            System.out.print("NO"+videoId);
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
        return videoId;
    }

    @Override
    public void removeAlyiVideo(String id) {

        try {
            DefaultAcsClient client = InitObject.initVodClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            DeleteVideoResponse response = new DeleteVideoResponse();

            DeleteVideoRequest request = new DeleteVideoRequest();
            //支持传入多个视频ID，多个用逗号分隔
            request.setVideoIds(id);
            System.out.println(id);
            response = client.getAcsResponse(request);
            System.out.println(response);
        } catch (ClientException e) {
            throw new GuliException(20001,"删除失败");
        }

    }

    @Override
    public void deleteBatch(List<String> videoIdList) {

        try {
            DefaultAcsClient client = InitObject.initVodClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            DeleteVideoResponse response = new DeleteVideoResponse();

            DeleteVideoRequest request = new DeleteVideoRequest();
            //支持传入多个视频ID，多个用逗号分隔
            String videoIds = StringUtil.join(videoIdList.toArray(), ",");
            request.setVideoIds(videoIds);
            response = client.getAcsResponse(request);
            System.out.println(response);
        } catch (ClientException e) {
            throw new GuliException(20001,"删除失败");
        }

    }


}
