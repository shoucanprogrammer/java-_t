package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.TopicService;
import com.atguigu.qqzone.service.UserBasicService;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;
    private String login(String loginId, String pwd, HttpSession session){
        //1.登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null){
            //1-1获取相关的好友信息
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2获取相关的日志列表信息（但是，日志只有id，没有其他信息）
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            //userBaic这个key保存的是登录者的信息
            //friend这个key保存的是当前进入的是谁的空间
            session.setAttribute("userBasic",userBasic);
            session.setAttribute("friend",userBasic);
            return "index";
        }else {
            return "login";
        }
    }
    public String friend(Integer id,HttpSession session){
        //1.根据id获取指定的用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);
        session.setAttribute("friend",currFriend);
        return "index";
    }



}
