package s2453_destroyTargets;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    @Test
    public void test(){
        destroyTargets(new int[]{3,7,8,1,1,5},2);
    }
    public int destroyTargets(int[] nums, int space) {
        Map<Integer,Integer> lenMap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> minMap = new HashMap<Integer,Integer>();
        for(int i : nums){// 按照对space取模的结果分组,并计算分组的长度和最小值
            int x = i % space;
            if(!lenMap.containsKey(x)){// 初始化
                lenMap.put(x,1);// 代表x可以打击的目标是1个
                minMap.put(x,i);
            }else{// 更新x对应的组长度和最小值
                lenMap.put(x,lenMap.get(x)+1);//累加x组的成员个数
                minMap.put(x,Math.min(minMap.get(x),i));// 打擂获得该组的最小值
            }
        }
        // 打擂找到最长的分组，以及最长分组中的最小值
        int len = lenMap.get(nums[0]%space), min = minMap.get(nums[0]%space);
        for(int i : lenMap.keySet()){
            if(len < lenMap.get(i)){// 选出最大长度的分组
                len = lenMap.get(i);
                min = minMap.get(i);
            }else if(len == lenMap.get(i)){// 相同长度分组，选择最小的nums值
                min = Math.min(min,minMap.get(i));
            }
        }
        return min;
    }
}
