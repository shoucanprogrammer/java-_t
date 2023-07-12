package s2006_countKDifference;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int j = 0; j < n; ++j) {
            res += cnt.getOrDefault(nums[j] - k, 0) + cnt.getOrDefault(nums[j] + k, 0);
            cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
        }
        return res;
    }
}
