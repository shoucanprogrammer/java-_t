package s16_threeSumClosest;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    @Test
    public void test(){
        int i = threeSumCloset(new int[]{1,1,1,1}, 0);
        System.out.println();
    }
    public int threeSumCloset(int[] nums, int target){
        int len = nums.length;
        Arrays.sort(nums);
        TreeMap<Integer, Integer> ClosetMap = new TreeMap<>();
        int i;
        for (i = 0; i < len; i++) {
            if (i >= 1)
                while (nums[i] == nums[i - 1]) {
                    i++;
                    if (i == len) {
                        return ClosetMap.get(ClosetMap.firstKey());
                    }
                }

            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] < target) {
                    L++;
                    if (L == R){
                        if (!ClosetMap.containsKey(Math.abs(nums[i] + nums[L-1] + nums[R]-target))){
                            ClosetMap.put(Math.abs(nums[i] + nums[L-1] + nums[R]-target),nums[i] + nums[L-1] + nums[R]);
                        }

                    }
                } else if (nums[i] + nums[L] + nums[R] > target) {
                    R--;
                    if (L == R){
                        if (!ClosetMap.containsKey(Math.abs(nums[i] + nums[L] + nums[R+1]-target)))
                            ClosetMap.put(Math.abs(nums[i] + nums[L] + nums[R+1]-target),nums[i] + nums[L] + nums[R+1]);
                    }

                } else {
                    return target;
                }

            }

        }
        return ClosetMap.get(ClosetMap.firstKey());
    }
}
