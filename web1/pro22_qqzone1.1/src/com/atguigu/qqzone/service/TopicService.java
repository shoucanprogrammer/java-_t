package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //查询特定用户的日志
    List<Topic> getTopicList(UserBasic userBasic);
    Topic getTopicByid(Integer id);
    //根据id获取指定的top信息，包含这个topic关联的作者信息
    public Topic getTopic(Integer id);
    //删除特定的topic
    void delTopic(Integer id);
    //删除指定的日志关联的所有回复





}
