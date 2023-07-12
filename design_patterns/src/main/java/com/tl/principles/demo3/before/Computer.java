package com.tl.principles.demo3.before;

public class Computer {
    private XiJieHardDisk hardDisk;
    private IntelCpu cpu;
    private KingstonMemory memory;
    public IntelCpu getCpu() {
        return cpu;
    }
    public void setCpu(IntelCpu cpu) {
        this.cpu = cpu;
    }
    public KingstonMemory getMemory() {
        return memory;
    }
    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

 public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }
    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }
    public void run() {
        System.out.println("计算机工作");
        cpu.run();
        memory.save();
        String data = hardDisk.get();
        System.out.println("从硬盘中获取的数据为：" + data);
    }
}
