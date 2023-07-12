package s926_minFlipsMonoIncr;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        minFlipsMonoIncr("00011000");
    }
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] preSum = new int[n];
        preSum[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++){
            preSum[i] += preSum[i-1] + s.charAt(i) - '0';
        }
        int ans = n - preSum[n-1];
        for (int i = 1; i <= n; i++){ //i作为mid为1
            int left1 = preSum[i-1];
            int right0 = (n  - i)-(preSum[n-1] - preSum[i-1]);
            ans = Math.min(left1+right0,ans);
        }
        return ans;
    }
}
