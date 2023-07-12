package s349_intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> res = new HashSet<Integer>();
//        res.addAll(set1);
        set1.retainAll(set2);
        int[] resArr = new int[set1.size()];
        int i = 0;
        for (Integer num : set1){
            resArr[i] = num;
            i++;
        }
//        Arrays.sort(resArr);
        return resArr;
    }
}
