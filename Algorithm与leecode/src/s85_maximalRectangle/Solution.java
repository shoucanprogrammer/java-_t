package s85_maximalRectangle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        if (len == 0) return 0;

        int row_len = matrix[0].length;
        int max = 0;
        int[] heights = new int[row_len];
        Arrays.fill(heights,0); // default

        for (int i = 0; i < len; i++){
            for (int j = 0; j < row_len; j++){
                if(matrix[i][j] - '0' == 0){ // 双脚离地了，直接归零了
                    heights[j] = 0;
                }else if(matrix[i][j] - '0' == 1){ // 累加高度
                    heights[j] += 1;
                }
            }
            // 一行计算完毕
            max = Math.max(largestRectangleArea(heights),max); // 按每行逐行更新最大值
        }


       return max;
    }
    public int largestRectangleArea(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            ans = Math.max(ans,(right[i] - left[i] -1) * heights[i]);
        }
        return ans;
    }

}
