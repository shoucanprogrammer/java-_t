package OfferII_38;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
//        Arrays.fill(ans,0);
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ){
                int pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        return ans;
    }
}
