package com.tl.principles.demo3.after;

public class KingstonMemory implements Memory{
    @Override
    public void save() {
        System.out.println("使用金士顿作为内存条");
    }
}
