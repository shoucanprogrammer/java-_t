package s9_isPalindrome;

import org.junit.Test;
public class Solution {
    @Test
    public void test(){
        isPalindrome1(12121);
    }
    public boolean isPalindrome(int x){
        String xStr = String.valueOf(x);
        int len = xStr.length();
        for (int i = 0; i < len/2;i++){
            if (xStr.charAt(i)!=xStr.charAt(len-1-i)){
                return false;
            }
        }
        return true;

    }
    public boolean isPalindrome1(int x){
        if (x<0 ||(x%10==0&&x!=0)){
            return false;
        }
        int xRverse = 0;
        while (x>xRverse){
            xRverse = xRverse*10+x%10;
            x = x/10;
        }
        return x == xRverse || x == xRverse / 10;
    }
}
