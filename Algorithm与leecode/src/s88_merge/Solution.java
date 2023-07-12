package s88_merge;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len  = nums1.length;
        int[] newnums = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;
        while (true){

           if ( j>=n||(nums1[i] < nums2[j]&&i<m)){
                newnums[k] = nums1[i];
                i++;
            }else  if (i>= m ||(nums1[i] >= nums2[j]&&j<n)){
               newnums[k] = nums2[j];
               j++;
           }
            k++;
           if (k==len){
               for (i = 0; i < len; i++){
                   nums1[i] = newnums[i];
               }
               break;
           }
        }
    }
}
