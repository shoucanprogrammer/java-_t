package LCR057_containsNearbyAlmostDuplicate;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    @Test
    public void test() {
        containsNearbyAlmostDuplicate(new int[] {1,5,9,1,5,9} ,2,3);
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long,Long> map = new TreeMap<>();
        int n = nums.length;
        //填充
        for (int i = 0; i < n && i < k; i++) {
            Long ceilingKey = map.ceilingKey((long)nums[i] - (long) t);
            if (ceilingKey != null &&   ceilingKey <= (long) nums[i] + (long) t){
                return true;
            }else {
                map.put((long)nums[i],(long)i);
            }
        }

        //开始循环遍历
        for (int i = k; i < n; i++) {
            Long ceilingKey = map.ceilingKey((long)nums[i] - (long) t);
            if (ceilingKey != null &&   ceilingKey <= (long) nums[i] + (long) t) {
                return true;
            }else {
                map.put((long)nums[i],(long)i);
                map.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
