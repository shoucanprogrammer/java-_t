package s11_maxArea;


import org.junit.Test;

public class Solution {
   @Test
    public void test(){
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int maxArea  = 0;
        int area ;
        while (left != right){
            area = (right-left)*Math.min(height[right],height[left]);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
            if (area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
