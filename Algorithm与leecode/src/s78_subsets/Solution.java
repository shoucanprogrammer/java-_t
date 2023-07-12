package s78_subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//public class Solution {
//    @Test
//    public void test(){
//        int[] nums = new int[]{1,2,3};
//        List<List<Integer>> subsets = subsets(nums);
//        System.out.println(subsets);
//    }
//    private List<List<Integer>> lists = new ArrayList<>();
//
//    public List<List<Integer>> subsets(int[] nums){
//        lists.add(new ArrayList<>());
//        if (nums==null){
//            return lists;
//        }
//        int a = nums.length;
//        for (int i = a ; i>0 ;i--){
//            dfs(0,i,nums,new ArrayList<>());
//        }
//        return lists;
//    }
//    public void dfs(int start,int count, int[] nums,ArrayList<Integer> list){
//        if (count==list.size()){
//             lists.add(new ArrayList<>(list));
//             return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            list.add(nums[i]);
//            dfs(i + 1, count, nums, list);
//            list.remove(list.size() - 1);
//        }
//    }
//}



public class Solution {
        @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    List<List<Integer>> ans;
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        list = new ArrayList<>();

        process(nums, 0);
        return ans;
    }

    public void process(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(list));

        // 子集不讲究顺序，所以[1,2]和[2,1]是同一子集
        // 题目要求不能返回重复子集
        // 所以 i 不能从 0 开始，要从 startIndex 开始。
        // 这样才能保证不断往后找，不能回头找
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            process(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }




//    List<Integer> t = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> subsets(int[] nums) {
//        int n = nums.length;
//        int a = (1 << n);
//        for (int mask = 0; mask < (1 << n); ++mask) {
//            t.clear();
//            for (int i = 0; i < n; ++i) {
//
//                if ((mask & (1 << i)) != 0) {
//                    t.add(nums[i]);
//                }
//            }
//            ans.add(new ArrayList<Integer>(t));
//        }
//        return ans;
//    }



}

