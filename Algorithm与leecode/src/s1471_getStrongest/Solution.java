package s1471_getStrongest;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = (arr.length-1)/2;
        int midValue = arr[m];
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1-midValue) == Math.abs(o2-midValue)){
                    return o2- o1;
                }else {
                    return Math.abs(o2-midValue)-Math.abs(o1-midValue);
                }

            }
        });
        int[] ans =  new int[k];
        for (int i = 0; i < k ; i++){
            ans[i] = nums[i];
        }
        return ans;
    }
}
