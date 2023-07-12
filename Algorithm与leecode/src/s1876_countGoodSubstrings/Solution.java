package s1876_countGoodSubstrings;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    @Test
    public void test(){
        countGoodSubstrings("aababcabc");
    }
    public int countGoodSubstrings(String s) {
        if (s.length()<3){
            return 0;
        }
        Map<Character,Integer> set = new HashMap<>();
       for (int i = 0; i < 3; i++){
           set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
       }
        int count = 0;
        if (set.size() == 3){
            count++;
        }
        for (int i = 1; i <= s.length()-3;i++){
            set.put(s.charAt(i-1),set.get(s.charAt(i-1))-1);
            if (set.get(s.charAt(i-1)) == 0){
                set.remove(s.charAt(i-1));
            }
            set.put(s.charAt(i+2), set.getOrDefault(s.charAt(i+2), 0) + 1);
            if (set.size() == 3){
                count++;
            }
        }
        return count;
    }
}
