package LCR007;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        threeSum(new int[]{-2,0,1,1,2});
    }
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        if (n < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int p = 0; p < n - 1; p++) {
            if (p > 0 && nums[p] == nums[p - 1] && p < n - 2) {
                continue;
            }
            int r = n - 1;
            for (int l = p + 1; l < n - 1; l++) {
                if (l > p + 1 && nums[l] == nums[l - 1] && l < r) {
                    continue;
                }
                while (l < r && nums[l] + nums[r] + nums[p] > 0) {
                    r--;
                }
                if (r == l) {
                    break;
                }
                if (nums[l] + nums[r] + nums[p]  == 0){
                    ArrayList<Integer> tem = new ArrayList<>();
                    tem.add(nums[p]);
                    tem.add(nums[l] );
                    tem.add(nums[r]);
                    res.add(tem);
                }
            }

        }
        return res;
    }
}
