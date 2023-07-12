package com.tl.principles.demo4.after;

import com.tl.principles.demo4.before.HeimaSafetyDoor;

public class Client {
    public static void main(String[] args) {
        //创建黑马安全门对象
        HeimaSafetyDoor door = new HeimaSafetyDoor();
        door.waterProof();
        door.antiTheft();
        door.fireProof();
    }
}
