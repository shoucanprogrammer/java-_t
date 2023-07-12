package s90_subsetsWithDup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        System.out.println(subsetsWithDup(new int[]{1,2,2,3}));
    }
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }
    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        //回溯
        t.remove(t.size() - 1);
    }

}
