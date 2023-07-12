package s695_maxAreaOfIsland;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    public void test(){

        maxAreaOfIsland(new int[][]{{1,1},{1,1}});
    }
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    //遍历
                    int dfs = dfs(i, j, grid);
                    grid[i][j] = 2;
                    ans = Math.max(ans,dfs);
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j, int[][] grid){
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (0 <= x && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                grid[x][y] = 2;
                res = res + dfs(x,y,grid);
            }
        }
        return res;
    }
}
