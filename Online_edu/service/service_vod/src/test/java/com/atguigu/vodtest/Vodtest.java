package com.atguigu.vodtest;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;

import java.util.List;

public class Vodtest {
    public static void main(String[] args) throws ClientException {
        //1 根据视频Id获取视频播放地址
        //创建初始化对象
        DefaultAcsClient client =  InitObject.initVodClient("LTAI5tG9kuNgvhgmwUM1Ac2n","6bytO9P0IpgMJCe39czSUEs0OUtkYD");

        //创建获取视频地址request和response
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();

        //向request对象里面设置视频id
        request.setVideoId("be961671d5224c9b9939d36f581365dd");

        //调用初始化对象里面的方法，传递request，获取数据
        response = client.getAcsResponse(request);

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList){
            System.out.print("PlayInfo.PlayURL"+playInfo.getPlayURL()+"\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = "+response.getVideoBase().getTitle()+"\n" );


    }
}
