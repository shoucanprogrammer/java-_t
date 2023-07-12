package s494_findTargetSumWays;

import org.junit.jupiter.api.Test;

public class Solution1 {
    @Test
    public void test(){
        findTargetSumWays(new int[]{1000},-1000);
    }
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }

        if (Math.abs(t) > s) {
            return 0;
        }
        int[][] f = new int[n + 1][2 * s + 1];
        f[0][s] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int x = nums[i-1];
            for (int j = 0; j < 2 * s + 1; j++){
                if (j - x >= 0) {
                    f[i][j - x] += f[i - 1][j];
                }
                if (j + x < 2 * s  +1 ){
                    f[i][j + x] += f[i - 1][j] ;
                }
            }
        }
        return f[n+1][s + t];
    }
}
