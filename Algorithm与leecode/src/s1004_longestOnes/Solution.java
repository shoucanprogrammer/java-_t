package s1004_longestOnes;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

