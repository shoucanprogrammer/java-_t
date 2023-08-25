package s496_nextGreaterElement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            while (!deque.isEmpty() && nums2[deque.peek()] < num){
                Integer pop = deque.pop();
               map.put(nums2[pop],num);
            }
            deque.push(i);
        }
        for (int i = 0; i < n; i++){
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }

        return res;
    }
}
