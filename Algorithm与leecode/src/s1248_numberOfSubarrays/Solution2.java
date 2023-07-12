package s1248_numberOfSubarrays;

import org.junit.Test;

public class Solution2 {
    @Test
    public void test(){
        numberOfSubarrays(new int[]{1,1,2,1,1},3);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] & 1);
            cnt[sum[i]]++;
        }
        // 考虑 [i, j] 范围内 奇数 个数为 k的区间有几个
        int res = 0;
        for (int j = 1; j <= n; j++) {
            if (sum[j] >= k)
                res += cnt[sum[j] - k];
        }
        return res;
    }
}