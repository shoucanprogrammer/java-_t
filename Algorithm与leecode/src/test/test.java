package test;

import org.testng.annotations.Test;

public class test {
    @Test
    public void test1(){
        int [] arr = {1,2,3,4,5,6,7,8,10};
        int [] newArr = new int[arr.length*2];
        for (int i = 0;i<arr.length;i++)
            newArr[i] = arr[i];
        arr = newArr;
        System.out.println();
    }


}
