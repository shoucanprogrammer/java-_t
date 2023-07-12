package s239_maxSlidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]>  queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o2[0] - o1[0];
                }
            }
        });
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++){
            queue.offer(new int[]{nums[i],i});
        }
        ans[0] =  queue.peek()[0];
        for (int i = 1; i < n - k + 1; i++){
            queue.offer(new int[]{nums[i+k],i+k});
            while (queue.peek()[1] <= i){
                queue.poll();
            }
            ans[i] = queue.peek()[0];
        }
        return ans;

    }
}
