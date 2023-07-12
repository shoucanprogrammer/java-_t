package s931_minFallingPathSum;

public class Solution {
    int ans = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 0; i < matrix.length;i++){
            traceBack(0,i,matrix,0);
        }
        return ans;
    }
    public void traceBack(int x,int y,int[][] matrix,int sum){
        if (x==matrix.length){
            ans = Math.min(ans,sum);
            return;
        }
        if (x < matrix.length&&y<matrix.length&&y>=0){
            sum += matrix[x][y];
            traceBack(x+1,y-1,matrix,sum);
            traceBack(x+1,y,matrix,sum);
            traceBack(x+1,y+1,matrix,sum);
        }
    }
}
