package com.atguigu.qqzone.pojo;

import java.time.LocalDateTime;
import java.util.Date;
//主人回复
public class HostReply {
    private Integer id;
    private String content;
    private LocalDateTime hostReplyDate;
    private UserBasic author;// M:1
    private Reply reply;    //  1:1
    public HostReply(){}

    public HostReply(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(LocalDateTime hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
