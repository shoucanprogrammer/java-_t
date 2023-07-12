package s845_longestMountain;

import org.junit.Test;

public class Solution1 {
    @Test
    public void test(){
        longestMountain(new int[]{2,1,4,7,3,2,5});
    }
    public int longestMountain(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len; i++){
           left[i] = arr[i] > arr[i -1] ? left[i-1] + 1: 0;
        }
        for (int i = len -2; i >= 0; i--){
            right[i] = arr[i] > arr[i + 1] ? right[i +1] + 1: 0;
        }

        int ans = 0;
        for (int i = 0; i < len; i++){
            if (left[i] > 0 && right[i] > 0){
                ans = Math.max(ans, right[i] + left[i] + 1);
            }
        }
        return ans;
    }
}
