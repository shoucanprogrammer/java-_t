package s813_largestSumOfAverages;

import org.junit.Test;

public class Solution1 {
    @Test
    public void test(){
        largestSumOfAverages(new int[]{1,2,3,4,5,6,7},4);
    }
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {//切分次数
            for (int i = j; i <= n; i++) {//数组长度
                for (int x = j - 1; x < i; x++) { //x切点
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
