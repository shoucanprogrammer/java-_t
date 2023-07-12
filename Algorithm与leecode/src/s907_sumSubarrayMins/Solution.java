package s907_sumSubarrayMins;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        sumSubarrayMins(new int[]{3,1,2,4});
    }
    int min ;
    long ans = 0;
    public int sumSubarrayMins(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            min = arr[i];
            ans += min;
            dfs(arr,i+1);
        }
        return (int)(ans%(Math.pow(10,9)+7));
    }
    public void dfs(int arr[],int i){
        if (i == arr.length){
            return;
        }
        min = Math.min(min,arr[i]);
        ans += min;
        dfs(arr,i+1);

    }
}
