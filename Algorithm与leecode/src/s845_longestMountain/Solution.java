package s845_longestMountain;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        longestMountain(new int[]{2,1,4,7,3,2,5});
    }
    public int longestMountain(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            int l = i;
            int r = i;
            int num = 1;
            boolean left = false;
            boolean right = false;
            while (l >= 1){
                if (arr[l] > arr[--l]){
                    num++;
                    left = true;
                }else {
                    break;
                }
            }
            while (r < arr.length - 1){
                if (arr[r] > arr[++r]){
                    right = true;
                    num++;
                }else {
                    break;
                }
            }
            if (right && left){
                max = Math.max(max,num);
            }
        }
    return max == 1 ? 0 : max;
    }
}
