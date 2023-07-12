package S216_combinationSum3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        combinationSum3(3,9);
    }
    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,1, n);
        return ans;
    }

    public void dfs(int k ,int start,int n ){
        if (k == 0 ){
            int sum = 0;
            for (Integer num : list){
                sum += num;
            }
            if (sum == n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i < 10&&i<= n; i++){
            list.add(i);
            dfs(k-1,i+1,n);
            list.remove(list.size()-1);
        }
    }
}
