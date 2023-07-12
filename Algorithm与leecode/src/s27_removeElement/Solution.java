package s27_removeElement;

import org.junit.Test;
public class Solution {

    public int removeElement(int[] nums,int val){
        int n = nums.length;
      if (n <= 0){
          return 0;
      }
      int left = 0;
      for (int right = 0; right < n; right++){
          if (nums[right] != val ){
              nums[left] = nums[right];
              left++;
          }
      }
      return left;
    }
}
