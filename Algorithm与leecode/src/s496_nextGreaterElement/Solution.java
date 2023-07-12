package s496_nextGreaterElement;

import java.util.Arrays;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        Arrays.fill(ans,-1);

        for (int i = 0; i < n1; i++){
            boolean fla = true;
            for (int j = 0; j < n2; j++){
                if (nums2[j] == nums1[i]){
                    for (int k = j + 1; k < n2; k++){
                        if (nums1[i] < nums2[k]){
                            ans[i] = nums2[k];
                            fla = false;
                            break;
                        }

                    }

                }
                if (!fla){
                    break;
                }
            }
        }
        return ans;
    }
}
