package s84_largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Arrays.fill(right,n);
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
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
