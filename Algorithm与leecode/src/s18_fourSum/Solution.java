package s18_fourSum;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        fourSum(new int[]{0,0,0,-1000000000,-1000000000,-1000000000,-1000000000

        }, -1000000000);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int four = n-1; four>=0;--four){
                if (four< n-1 && nums[four] == nums[four+1]){
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = four - 1;
                // 枚举 b
                for (int second = first + 1; second < four; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] + nums[first] + nums[four]> target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] + nums[first] + nums[four]== target ) {
                        boolean fla = true;
                        boolean fla1 = true;
                        int nums1[] = new int[]{nums[first],nums[second],nums[third],nums[four]};
//                    nums1 = nums.clone();
                        int nums2[];
                        nums2 = nums1.clone();
                        for (int i = 0 ; i < 3; i++){
                            if (fla&&fla1){
                                fla = isNotAddExact(nums1[i],nums1[i + 1]);
                                fla1 = isNotSubtractExact(nums[i],nums1[i+1] );
                                if (!(fla&&fla1)){
                                    break;
                                }
                                nums1[i+1] = nums1[i] + nums1[i+1];
                                nums2[i+1] = nums2[i] - nums2[i+1];
                            }
                        }
                        if (fla&&fla1){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[first]);
                            list.add(nums[second]);
                            list.add(nums[third]);
                            list.add(nums[four]);
                            ans.add(list);
                        }


                    }
                }

            }

        }
        return ans;
    }
    public static boolean isNotAddExact(int x, int y) {
        int r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            return false;
        }
        return true;
    }
    public static boolean isNotSubtractExact(int x, int y) {
        int r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different from the sign of x
        if (((x ^ y) & (x ^ r)) < 0) {
            return false;
        }
        return true;
    }

}
