package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyListByTopicId(Integer topicId);
    //添加回复
    void addReply(Reply reply);
    //删除指定回复
    void delReply(Integer id);
    void delReplyList(Topic topic);
}
