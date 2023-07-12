package s326_isPowerOfThree;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        isPowerOfThree(27);
    }
    public boolean isPowerOfThree(int n) {
        boolean f = f(n);
        return f;
    }
    private boolean f(int n) {
        if (n == 1){
            return true;
        }else if (n == 0 || n%3!=0){
            return false;
        }
        return f(n/3);
    }
}
