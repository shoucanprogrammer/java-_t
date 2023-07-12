package s438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cont = new int[26];
        int[] cont1 = new int[26];
        int m = s.length();
        int n = p.length();
        if(m<n){
            return ans;
        }
        //初始
        for (int i = 0; i < n; i++){
            cont[s.charAt(i)-'a']++;
            cont1[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(cont,cont1)){
            ans.add(0);
        }
        //滑动
        for (int i = 1; i < m -n + 1; i++){
            cont[s.charAt(i-1)-'a']--;
            cont[s.charAt(i+n-1)-'a']++;
            if (Arrays.equals(cont,cont1)){
                ans.add(i);
            }
        }
        return ans;
    }
}