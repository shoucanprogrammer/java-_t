package s503_nextGreaterElements;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    @Test
    public void test(){
        nextGreaterElements(new int[]{1,2,3,4,3});
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret,-1);
        Deque<Integer> steak = new LinkedList<>();
        for (int i = 0; i < n*2-1; i++){
            while (!steak.isEmpty()&&nums[steak.peek()]<nums[i%n]){
                ret[steak.pop()] = nums[i%n];
            }
            steak.push(i%n);
        }
        return ret;
    }
}

