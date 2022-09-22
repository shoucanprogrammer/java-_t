package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;
import com.mysql.cj.util.DnsSrv;

import javax.servlet.http.HttpSession;
import java.util.List;

public class TopicController {
    private  TopicService topicService;
    public String topicDetail(Integer id, HttpSession session){
        Topic topic = topicService.getTopicByid(id);

        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        //从session中获取当前用户信息
        UserBasic userBasic = (UserBasic)session.getAttribute("userBasic");
        //再次查询当前用户关联的所有日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //设置一下关联的日志列表(因为之前session中关联的friend的topicList和此刻数据库中不一致)
        userBasic.setTopicList(topicList);
        //重新覆盖一下friend中的信息（为什么不覆盖userbasic中？因为main.html页面迭代的是friend这个key的中数据）
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }

}
