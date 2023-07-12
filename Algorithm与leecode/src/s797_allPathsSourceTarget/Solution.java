package s797_allPathsSourceTarget;

import java.util.*;

public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        stack.offerLast(0);
        dfs(graph,0,n-1);
        return ans;
    }

    public void dfs(int[][] graph,int i , int n){
        if (i == n){
            ans.add(new LinkedList<>(stack));
            return;
        }
        for (int x : graph[i]){
            stack.offerLast(x);
            dfs(graph,x,n);
            stack.pollLast();
        }
    }

}
