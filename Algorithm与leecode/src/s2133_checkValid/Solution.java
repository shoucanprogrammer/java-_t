package s2133_checkValid;

import java.util.Arrays;

public class Solution {
    public boolean checkValid(int[][] matrix) {
        int len = matrix.length;
        int[] nums = new int[len];
        Arrays.fill(nums,1);
        for (int i = 0; i < len; i++){
            int[] nums1 = new int[len];
            int[] nums2 = new int[len];
            for (int j = 0; j < len; j++){
                nums1[matrix[i][j]-1]++;
                nums2[matrix[j][i]-1]++;
            }
            if (Arrays.equals(nums,nums1)&&Arrays.equals(nums,nums2)){
                //行和列都满足
            }else {  //有一个不满足
                return false;
            }
        }
        return true;
    }
}
