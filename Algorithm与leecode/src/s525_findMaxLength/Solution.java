package s525_findMaxLength;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        findMaxLength(new int[]{1,1,1,1,1,1,1,1});
    }
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[n+1];
        prefixSums[0] = 0;
        for (int i = 1; i <= n; i++){
            if (nums[i-1] == 0){
                prefixSums[i] = prefixSums[i-1] -1;
            }else {
                prefixSums[i] = prefixSums[i-1] + 1;
            }
        }
        int ans = 0;
        int k = 0;
        for (int i = 0; i < n; i++){
            for (int j = n ; j >= k; j--){
                if (prefixSums[j] - prefixSums[i] == 0){
                    ans = Math.max(ans,j-i);
                    k = j;
                    break;
                }
            }
        }
    return ans;
    }
}
