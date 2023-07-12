package s802_eventualSafeNodes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (safe(graph,color,i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean safe(int[][] graph,int[] color,int i){
        if (color[i] == 1){//成环
            return false;
        }else if (color[i] == 2){//安全节点
            return true;
        }
        color[i] = 1;
        for (Integer y : graph[i]){
            if (!safe(graph,color,y)){
//                color[y] = 0;
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
}
