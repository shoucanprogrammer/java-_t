package s167_twoSum;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        twoSum(new int[]{2,7,11,15},9);
    }
    public int[] twoSum(int[] numbers, int target){
        int[] sumArr = new int[2];
        for (int i = 0; i < numbers.length; i++){
            int low = i + 1,hight = numbers.length - 1;
            int res = target - numbers[i];
            sumArr[0] = i+1;
            while (low <= hight){
                int mid = (low + hight) / 2;
                if (numbers[mid] == res){
                    sumArr[1] = mid + 1;
                    break;
                }else if (numbers[mid] < res){
                    low = mid + 1;
                }else if (numbers[mid] > res){
                    hight = mid - 1;
                }
            }
            if (sumArr[1] != 0){
                break;
            }
        }
        return sumArr;
    }
}
