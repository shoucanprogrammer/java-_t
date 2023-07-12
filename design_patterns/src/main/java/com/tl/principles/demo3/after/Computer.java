package com.tl.principles.demo3.after;

import com.tl.principles.demo3.before.IntelCpu;
import com.tl.principles.demo3.before.KingstonMemory;
import com.tl.principles.demo3.before.XiJieHardDisk;

public class Computer {
    private HardDisk hardDisk;
    private Cpu cpu;
    private Memory memory;


    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }
    public void run() {
        System.out.println("计算机工作");
        cpu.run();
        memory.save();
        String data = hardDisk.get();
        System.out.println("从硬盘中获取的数据为：" + data);
    }
}
