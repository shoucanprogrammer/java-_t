package com.tl.pattern.responsibility;

public class Client {
    public static void main(String[] args) {
        //创建一个请假条对象
        LeaveRequest leave = new LeaveRequest("小明",1,"身体不适");
        //创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        //设置处理者链
        generalManager.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //小明提交请假申请
        groupLeader.submit(leave);
    }
}
