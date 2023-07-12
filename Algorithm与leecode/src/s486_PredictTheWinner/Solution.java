package s486_PredictTheWinner;

import org.junit.Test;

import java.util.Properties;

public class Solution {
    @Test
    public void test(){
        PredictTheWinner(new int[]{1,5,2});
    }
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1) >= 0;
    }

    public int total(int[] nums, int start, int end) { //去掉turn参数。不管当前是A玩家选还是B玩家选，我们都返回一个分数，代表当前玩家得分，减去另一玩家的得分。
        if (start == end) {
            return nums[start];
        }
        int scoreStart = nums[start] - total(nums, start + 1, end); //这里第二项从加号改为减号。
        int scoreEnd = nums[end] - total(nums, start, end - 1); //这里第二项从加号改为减号。
        return Math.max(scoreStart, scoreEnd); //直接返回最大值就好了，不需要知道当前玩家是谁。
    }
}
