package s39_combinationSum;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        List<List<Integer>> lists = combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println();
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);//排序
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点

        if (target == 0) {
            List listPath = new ArrayList<>(path);;
//            if (res.contains(listPath))
//                return;
            res.add(listPath);
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0)
                break;
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i+1, len, target - candidates[i], path, res);
            while (i+1 < len && candidates[i] == candidates[i+1]){
                i++;
            }
            // 状态重置
            path.removeLast();
        }
    }
}
