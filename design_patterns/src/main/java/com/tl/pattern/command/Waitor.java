package com.tl.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员类
 */
public class Waitor {
    //持有命令对象
    private List<Command> commands = new ArrayList<>();
    public void setCommands(Command cmd){
        //将cmd对象存储到list集合中
        commands.add(cmd);
    }

    //发起命令功能 喊 订单来了
    public void orderUp(){
        System.out.println("服务员:大厨，新订单来了。。。");
        for (Command command : commands){
            if (command != null){
                command.execute();
            }
        }
    }
}
