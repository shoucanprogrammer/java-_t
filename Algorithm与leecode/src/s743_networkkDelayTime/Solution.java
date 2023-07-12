package s743_networkkDelayTime;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2);
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE/2;
        int[][]  g= new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(g[i],INF);
        }
        for (int[] t: times){
            int x = t[0]-1,y = t[1] -1;
            g[x][y] = t[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist,INF);
        dist[k-1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++){
            int x = -1;
            for (int y = 0; y < n; y++){
                if (!used[y]&&(x==-1||dist[y]<dist[x])){
                    x = y;  //选择路径最短的节点进行更新
                }
            }
            used[x] = true;
            for (int y = 0; y < n; y++){
                dist[y] =  Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
