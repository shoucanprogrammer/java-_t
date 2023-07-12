package mianshi_solveNQueens;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n){
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        traceBack(0,n,columnSet,set1,set2,tem,ans);
        List<List<String>> ansS = new ArrayList<>();

        for (List<Integer> tem1: ans){
            List<String> temS = new ArrayList<>();
            for (int num : tem1){
                char[] chars = new char[n];
                Arrays.fill(chars,'.');
                chars[num] = 'Q';
                temS.add(String.valueOf(chars));
            }
            ansS.add(temS);
        }
        return ansS;
    }
    private void traceBack(int k,int n ,Set<Integer> columnSet,Set<Integer> set1,Set<Integer> set2,List<Integer> tem,List<List<Integer>> ans){
        if (tem.size() == n){
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i = 0; i < n; i++){
            if (!columnSet.contains(i)&&!set1.contains(i-k)&&!set2.contains(i+k)){
                    tem.add(i);
                    columnSet.add(i);
                    set1.add(i-k);
                    set2.add(i+k);
                    traceBack(k+1,n,columnSet,set1,set2,tem,ans);
                    tem.remove(tem.size()-1);
                    columnSet.remove(i);
                    set1.remove(i-k);
                    set2.remove(i+k);
            }
        }
    }
}
