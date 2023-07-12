package s456_find132pattern;

import java.util.TreeMap;

class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int k = 2; k < len; k++){//放右侧
            map.put(nums[k],map.getOrDefault(nums[k],0)+1);
        }
        int leftMin = nums[0];

        for (int j = 1; j  < len -1; j++){
            if (leftMin < nums[j]){
                Integer next = map.ceilingKey(leftMin+1);
                if (next!=null&&next<nums[j]){
                    return true;
                }
            }
            leftMin = Math.min(leftMin,nums[j]);
            map.put(nums[j+1],map.get(nums[j+1])-1 );
            if (map.get(nums[j+1]) == 0){
                map.remove(nums[j+1]);
            }

        }
        return false;
    }
}

