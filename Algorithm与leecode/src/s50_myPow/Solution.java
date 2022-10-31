package s50_myPow;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        double v = myPow(2, -2);
        System.out.println(v);
    }
    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0){
            return res;
        }
        if (n > 0){
           res = quickMul(x, n);
        }
        if (n < 0 ){
            res = 1/quickMul(x, -n);
        }
        return res;
    }
    public double quickMul(double x, long N) {
        if (N == 0){
            return 1.0;
        }
        double res = quickMul(x,N/2);
        if (N % 2== 0){
            res = res * res;
        }else {
            res = x * res * res;
        }
        return res;
    }
}
