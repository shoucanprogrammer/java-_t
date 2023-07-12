package s215_findKthLargest;

import java.util.Arrays;
import java.util.PriorityQueue;

//public class Solution {
//    public int findKthLargest(int[] nums, int k){
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
//        for (int i = 0 ; i < nums.length; i++){
//            if (queue.size()<k||nums[i]>queue.peek()){
//                queue.offer(nums[i]);
//            }
//            if (queue.size() > k){
//                queue.poll();
//            }
//        }
//        return queue.peek();
//    }
//}
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
