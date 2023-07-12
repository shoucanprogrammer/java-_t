package s463_islandPerimeter;

public class Solution {
    int ans = 0;
    private boolean[][] visit;
    private static final int[][] DIRECT = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visit = new boolean[m][n];
        boolean fla = true;
        for (int i = 0; i < m && fla; i++){
            for (int j = 0; j < n && fla; j++){
                if (grid[i][j] == 1){
                    dfs(i,j,grid);
                    fla = false;
                    break;
                }

            }
            if (!fla){
                break;
            }
        }
        return ans;
    }

    public void dfs(int i,int j,int[][] grid){
        visit[i][j] = true;
        for (int[] dir : DIRECT){
            if (0<=dir[0]+i &&
                    dir[0] + i <grid.length &&  0<=dir[1]+j && dir[1] + j <grid[0].length&&
                    grid[dir[0] + i][dir[1] + j]==1){
                if (!visit[dir[0] + i][dir[1] + j]){
                    dfs(dir[0] + i,dir[1] + j,grid);
                }
            }else {
                ans++;
            }
        }
    }

}
