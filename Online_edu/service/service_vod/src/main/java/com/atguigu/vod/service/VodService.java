package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    String uploadAlyiVideo(MultipartFile file);

    void removeAlyiVideo(String id);

    void deleteBatch(List<String> videoIdList);
}
