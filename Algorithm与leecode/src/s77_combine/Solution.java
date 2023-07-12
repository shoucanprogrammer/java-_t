package s77_combine;

//class Solution {
//    private List<List<Integer>> ans = new ArrayList<>();
//
//    public List<List<Integer>> combine(int n, int k) {
//        getCombine(n, k, 1, new ArrayList<>());
//        return ans;
//    }
//
//    public void getCombine(int n, int k, int start, List<Integer> list) {
//        if(k == 0) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        for(int i = start;i <= n - k + 1;i++) {
//            list.add(i);
//            getCombine(n, k - 1, i+1, list);
//            list.remove(list.size() - 1);
//        }
//    }
//}


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        combine(4,5);
    }
    private List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    // 用来存放临时数组

    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
       }


        public void dfs(int start,int end, int k){
            //剪枝
            if (end - start +1 < k){
                return;
            }else if (k==0){
                ans.add(new ArrayList<>(temp));
                return;
            }else {
                for (int i = start; i <= end  ; i ++){
                    temp.add(i);
                    dfs(i+1,end,k-1);
                    temp.remove(temp.size()-1);
                }
            }

        }
}
