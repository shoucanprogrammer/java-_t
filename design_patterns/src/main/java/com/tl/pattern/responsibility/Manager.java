package com.tl.pattern.responsibility;

/**
 * 部门经理类
 */
public class Manager extends Handler{
    public Manager(){
        super(NUM_ONE,Handler.NUM_THREE);
    }
    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getNum()+"请假"+leave.getNum()+"天"+leave.getContent()+"。");
        System.out.println("部门经理审批：同意");
    }
}
