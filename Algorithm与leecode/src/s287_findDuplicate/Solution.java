package s287_findDuplicate;

import org.junit.Test;

//public class Solution {
//    public int findDuplicate(int[] nums) {
//        for (int i=0; i < nums.length ; i++){
//            for (int j= i+1; j < nums.length;j++){
//                if (nums[j] == nums[i]){
//                    return nums[i];
//                }
//            }
//        }
//    return 0;
//    }
//}

//public class Solution {
//    @Test
//    public void test(){
//        int duplicate = findDuplicate(new int[]{1, 4, 4, 5, 5, 5});
//    }
//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int l = 1, r = n - 1, ans = -1;
//        while (l <= r) {
//            int mid = (l + r) >> 1;//坐标
//            int cnt = 0;
//            for (int i = 0; i < n; ++i) {
//                if (nums[i] <= mid) { //
//                    cnt++;
//                }
//            }
//            if (cnt <= mid) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//                ans = mid;
//            }
//        }
//        return ans;
//    }
//}
//
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);
        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}