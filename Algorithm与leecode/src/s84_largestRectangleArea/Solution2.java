package s84_largestRectangleArea;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {
    @Test
    public void test(){
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n -1; i >= 0; i--){
            while (!stack.isEmpty()&&heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            ans = Math.max((heights[i] * (right[i] - left[i] - 1)), ans);
        }
        return ans;
    }
}
