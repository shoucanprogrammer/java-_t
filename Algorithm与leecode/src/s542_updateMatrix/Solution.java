package s542_updateMatrix;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    @Test
    public void test(){
        updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
    }
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        int[][] newMatrix =  new int[matrix.length][matrix[0].length];
        for ( int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 1){//层次遍历
                  Queue<int[]> queue = new LinkedList<>();
                  queue.offer(new int[]{i,j});
                  boolean flag = false;
                    int count = 1;
                    while (!queue.isEmpty()&&!flag){
                        int size = queue.size();
                        for (int k = 0; k < size; k++){
                            int[] num = queue.poll();
                            for (int[] dir : dirs){
                                if ( num[0] + dir[0] >= 0 && num[0] + dir[0]  < matrix.length && num[1] + dir[1]  >= 0
                                        && num[1] + dir[1]  < matrix[0].length && matrix[num[0] + dir[0]][num[1] + dir[1]] == 0){
                                    flag = true;
                                    newMatrix[i][j] = count;
                                    break;
                                }else if (num[0] + dir[0] >= 0 && num[0] + dir[0]  < matrix.length && num[1] + dir[1]  >= 0
                                        && num[1] + dir[1]  < matrix[0].length && matrix[num[0] + dir[0]][num[1] + dir[1]] == 1){
                                    queue.offer(new int[]{num[0] + dir[0],num[1] + dir[1] });
                                }

                            }
                            if (flag){
                                break;
                            }
                        }
                        count++;
                    }
                }
            }
        }
    return newMatrix;
    }
}

