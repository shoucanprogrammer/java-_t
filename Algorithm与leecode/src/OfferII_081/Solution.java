package OfferII_081;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7},7);
    }
    private Set set = new HashSet<>();
    private List<Integer> res = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    int i = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0){

            Object[] array = res.stream().toArray();
            Arrays.sort(array);
            String s = Arrays.toString(array);
            boolean add = set.add(s);
            if (add){
                ans.add(new ArrayList(res));
                return ans;
            }
            return null;
        }else if (target < 0){
            return null;
        }
        for (int i = 0; i < candidates.length; i++){
            if(i> 0 && candidates[i] == candidates[i-1]){
                continue;
            }
            res.add(candidates[i]);
            combinationSum(candidates,target - candidates[i]);
            res.remove(res.size()-1);
        }
        return ans;
    }
}