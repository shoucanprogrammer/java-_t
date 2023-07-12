package s2054_maxTwoEvents;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution2 {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            int[] e = events[i];
            int start = e[0], end = e[1], value = e[2];
            while (!queue.isEmpty() && queue.peek()[0] < start) {
                int[] cur = queue.poll();
                max = Math.max(max, cur[1]);//最早出来的最大 value
            }
            ans = Math.max(value + max, ans);
            queue.offer(new int[] { end, value });
        }
        return ans;
    }
}