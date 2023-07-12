package com.tl.principles.demo4.before;

public class HeimaSafetyDoor implements SafetyDoor{

    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireProof() {
        System.out.println("防活");
    }

    @Override
    public void waterProof() {
        System.out.println("防水");
    }
}
