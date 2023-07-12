package s763_partitionLabels;

import asort.InsertSort;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++){
            end = Math.max(end,arr[s.charAt(i) - 'a']);
            if (i == end){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
