package s496_nextGreaterElement;

import java.util.*;

public class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < n2; i++){
            while (!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[n1];

        for (int i = 0; i < n1; i++){
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1 ;
        }
        return res;
    }
}
