package s1020_numEnclaves;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        numEnclaves(new int[][]{{1, 0}, {1, 0}});
    }
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid) {
        //边界广度遍历
        for (int i = 0; i < grid.length; i++){
            if (grid[i][0] == 1){
                dfs(i,0,grid);
            }
            if (grid[i][grid[0].length-1] == 1){
                dfs(i,grid[0].length-1,grid);
            }

        }
        for (int i = 0; i < grid.length; i++){
            if (grid[0][i] == 1){
                dfs(0,i,grid);
            }
            if (grid[grid.length-1][i] == 1){
                dfs(grid.length-1,i,grid);
            }
        }
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int x,int y,int[][] grid){
        if (0<=x&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y] == 1){
            grid[x][y] = 0;
            for (int[] num : dir){
                    dfs(x+num[0],y+num[1],grid);
                }
            }
        }

}
