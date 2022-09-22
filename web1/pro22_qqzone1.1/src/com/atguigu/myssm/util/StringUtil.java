package com.atguigu.myssm.util;

public class StringUtil {
    public static boolean isEmpty(String str){
        return str == null || " ".equals(str);
    }

    public static boolean isNOtEmpty(String str){
        return !isEmpty(str);
    }
}
