package com.tl.principles.demo3.before;

public class ComputerDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setHardDisk(new XiJieHardDisk());
        computer.setCpu(new IntelCpu());
        computer.setMemory(new KingstonMemory());
        computer.run();
    }
}
