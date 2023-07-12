package s785_isBipartite;

import java.util.Arrays;

public class Solution {
    private static final int UNCOLORED = 0;
    private  static final int RED = 1;
    private static  final int GREEN = 2;
    private int[] color;
    private boolean valid;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++){
            if (color[i] == UNCOLORED){
                dfs(i,RED,graph);
            }
        }
        return valid;
    }

    private void dfs(int i, int c, int[][] graph) {
        color[i] = c;
        int c1 = c == RED ? GREEN : RED;
        for (int num : graph[i]){
            if (color[num] == UNCOLORED){
                dfs(num,c1,graph);
                if (valid == false){
                    return;
                }
            }else if (color[num] == c){
                valid = false;
                return;
            }
        }
    }

}
