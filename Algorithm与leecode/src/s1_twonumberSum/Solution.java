package s1_twonumberSum;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static class test {
        @Test
        public void test1(){
            int [] arr = {1,2,3,4,5,6,7,8,10};
            int [] newArr = new int[arr.length*2];
            SolutionHashmap map = new SolutionHashmap();
            int[] ints = map.twoSum(arr, 8);
            for (int item:ints){
                System.out.println(item);
            }

//            for (int i = 0;i<arr.length;i++)
//                newArr[i] = arr[i];
//            arr = newArr;
//            System.out.println();
        }


    }
}
class SolutionHashmap {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashmap.containsKey(target-nums[i])){
                return new int[]{hashmap.get(target-nums[i]),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }

}
