package OfferII084;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visited =  new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        Arrays.sort(nums);
        traceBack(ans,tem,visited,nums);
        return ans;
    }
    public void traceBack(List<List<Integer>> ans,List<Integer> tem,boolean[] visited,int[] nums){
        if (tem.size() == nums.length){
            Arrays.sort(nums);
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] || (i > 0 && nums[i] == nums[i -1] && !visited[i - 1])){
                continue;
            }
            tem.add(nums[i]);
            visited[i] = true;
            traceBack(ans,tem,visited,nums);
            visited[i] = false;
            tem.remove(tem.size()-1);
        }
    }
}
