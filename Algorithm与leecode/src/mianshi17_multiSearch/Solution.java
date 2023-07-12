package mianshi17_multiSearch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] multiSearch(String big, String[] smalls) {
        int[][] ans = new int[smalls.length][];
        int  k = 0;
        for (String s : smalls){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < big.length(); i++){
                for (int j = i; j < big.length()&&j-i<s.length(); j++){
                    if ( big.charAt(j) == s.charAt(j-i)){
                    }else {
                        break;
                    }
                    if (j-i == s.length() -1){ //找到
                        list.add(i);
                    }
                }
            }
            ans[k] = new int[list.size()];
            int j = 0;
            for (int label : list){
                ans[k][j] = label;
                j++;
            }
            k++;
        }
        return ans;
    }
}
