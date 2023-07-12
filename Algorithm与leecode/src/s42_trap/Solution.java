package s42_trap;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = height.length;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int pop = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int with = i - stack.peek() -1;
                int heigh1 = Math.min(height[stack.peek()],height[i] )- height[pop];
                ans += with * heigh1;
            }
            stack.push(i);
        }
        return ans;
    }
}
