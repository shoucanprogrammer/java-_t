package offer_combine;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        traceBack(1,n,k);
        return ans;
    }
    public void traceBack(int start , int n , int k){
        if (res.size() == k){
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = start; i <= n; i++){
            res.add(i);
            traceBack(i+1,n,k);
            res.remove(res.size()-1);
        }
    }
}
