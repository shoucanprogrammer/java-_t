package s70_climbStairs;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        int i = climbStairs(5);
        System.out.println(1);
    }
    //递归
//    public int climbStairs(int n){
//        if (n==1){
//            return 1;
//        }
//        if (n == 2){
//            return 2;
//        }
//        return  climbStairs(n-1) + climbStairs(n-2);
//    }
    //动态规划  滚动数组
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}

