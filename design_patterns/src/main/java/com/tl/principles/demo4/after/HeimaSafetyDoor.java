package com.tl.principles.demo4.after;

import com.tl.principles.demo4.before.SafetyDoor;

public class HeimaSafetyDoor implements AntiTheft,Fireproof,WaterProof {


    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防活");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }
}
