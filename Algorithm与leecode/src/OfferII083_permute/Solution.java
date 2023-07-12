package OfferII083_permute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        permute(new int[]{1,2,3});
    }
    boolean[] used ;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tem = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        used = new boolean[len];
        traceBack(used,nums,0);
        return ans;
    }

    public void traceBack(boolean[] used,int[] nums,int n){
        if (n == nums.length){
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i = 0; i < nums.length ;i++){
            if (!used[i]){
                tem.add(nums[i]);
                used[i] = true;
                traceBack(used,nums,n+1);
                used[i] = false;
                tem.remove(tem.size()-1);
            }

        }
    }
}
