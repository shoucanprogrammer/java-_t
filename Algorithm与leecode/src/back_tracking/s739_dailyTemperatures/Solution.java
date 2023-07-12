package back_tracking.s739_dailyTemperatures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Arrays.fill(res,0);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++){
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i] ){
                Integer pop = deque.pop();
                res[pop] = i - pop;
            }
            deque.push(i);
        }
        return res;
    }
}
