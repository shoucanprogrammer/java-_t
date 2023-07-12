package s1674_minMoves;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        minMoves(new int[]{1,3,4,2},5);
    }
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[limit * 2 + 1];
        for (int i = 0; i < nums.length / 2; i++) {
            int max = Math.max(nums[i], nums[nums.length - i - 1]);
            int min = Math.min(nums[i], nums[nums.length - i - 1]);
            if (min == 1) {
                diff[2] += 1;
            } else{
                diff[2] += 2;
                diff[min + 1] -= 1;
            }
            diff[max + min] -= 1;
            if (max + min + 1 < diff.length) {
                diff[max + min + 1] += 1;
            }
            if (max + limit + 1 < diff.length) {
                diff[max + limit + 1] += 1;
            }
        }
        int now = 0, res = nums.length / 2;
        for (int i = 2; i < diff.length; i++) {
            now += diff[i];
            res = Math.min(res, now);
        }
        return res;
    }
}


