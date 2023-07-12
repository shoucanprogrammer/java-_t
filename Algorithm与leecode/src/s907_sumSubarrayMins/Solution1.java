package s907_sumSubarrayMins;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1 {

    public int sumSubarrayMins(int[] arr) {
        long mod = (long) 1e9 + 7;
        long ans = 0L;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.push(-1); // 哨兵
        for (int right = 0; right <= arr.length; ++right) {
            int cur = right < arr.length ? arr[right] : -1; // 假设 arr 末尾有个 -1

            // 找min,栈顶的元素，比当前大，则pop,说明说明呢？

            while (deque.size() > 1 && arr[deque.peek()] >= cur) {
                int top = deque.pop();
                ans += (long) arr[top] * (top - deque.peek()) * (right - top); // 累加贡献
            }

            deque.push(right);
        }
        return (int) (ans % mod);
    }
}

