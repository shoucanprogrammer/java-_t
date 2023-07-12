package s74_searchMatrix;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        boolean b = searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
        System.out.println(1);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int end = m*n-1;
        int start = 0;
        while (start <= end){
            int mid = (end + start ) /2;
            int x = mid / n;
            int y = mid % n;
            if (matrix[x][y] == target){
                return true;
            }else if (end == start){
                return false;
            }else if (matrix[x][y] > target){
                end = mid - 1;
            }else if (matrix[x][y] < target){
                start = mid + 1;
            }
        }
        return false;
    }
}
