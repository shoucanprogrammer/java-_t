package s46_Permute;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        permute(new int[]{1,1,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums,len,0,path,used,res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);

                used[i]  = false;
                path.removeLast();
                while (i+1<len&&nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
    }

}
