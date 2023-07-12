package s718_findLength;

public class Solution {
    public int findLength(int[] nums1,int[] nums2){
        int ans = 0;
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                int i1 = i;
                int j1= j;
                int count = 0;
                while (i1< nums1.length&& j1< nums2.length&&nums1[i1++] == nums2[j1++]){
                    count++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
