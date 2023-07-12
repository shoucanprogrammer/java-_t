package s1248_numberOfSubarrays;

class Solution3 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int res = 0;
        for (int num : nums) {
            sum += num & 1;
            cnt[sum]++;
            if (sum >= k) {
                res += cnt[sum - k];
            }
        }
        return res;
    }
}