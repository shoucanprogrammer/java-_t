package s200_numIslands;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},
                {'1','1','0','0','0'},{'0','0','0','0','0'}});
    }
    public void dfs(int x,int y , char[][] grid){

        if (x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        //上下左右遍历
        dfs(x-1,y,grid);
        dfs(x+1,y,grid);
        dfs(x,y+1,grid);
        dfs(x,y-1,grid);
    }
    public int numIslands(char[][] grid){
        int xLen = grid.length;
        int yLen = grid[0].length;
        int num = 0;
        for (int i = 0 ; i < xLen; i++){
            for (int j =0; j < yLen; j++){
                if (grid[i][j] == '1'){
                    dfs(i,j,grid);
                    num++;
                }
            }
        }
        return num;
    }
}
