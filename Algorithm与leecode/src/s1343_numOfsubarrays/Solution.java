package s1343_numOfsubarrays;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4);
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int num = 0;
        int sum = 0;
        int l = 0;
        for(int r = 0; r < arr.length; r++){
            sum += arr[r];
            if (r - l == k -1){//满了
                if (sum >= k*threshold){
                    num++;
                }
                sum = sum - arr[l];
                l++;
            }
        }
        return num;
    }
}
