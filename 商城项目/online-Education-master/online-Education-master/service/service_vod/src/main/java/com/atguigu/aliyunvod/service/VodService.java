package com.atguigu.aliyunvod.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface VodService {
    String uploadVIdeo(MultipartFile file);

    void removeVideo(String videoId);

    void removeAllVideo(List videoIdList);
}
