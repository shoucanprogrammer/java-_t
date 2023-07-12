package s310_findMinHeighyTrees;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        findMinHeightTrees(6,new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < adj.length; i++){
            LinkedList<Integer> queue = new LinkedList<>();
            HashSet<Integer> set = new HashSet<>();
            queue.add(i);
            set.add(i);
            int num = 1;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int j = 0; j <  size ; j++){
                    int root = queue.poll();
                    for (Integer chiroot : adj[root]){
                        if (!set.contains(chiroot)){
                            queue.add(chiroot);
                            set.add(chiroot);
                        }
                    }
                }
                num++;
            }
            if (num<min){
                ans.clear();
                min = Math.min(min,num);
                ans.add(i);
            }else if (num==min){
                ans.add(i);
            }

        }
    return ans;
    }
}
