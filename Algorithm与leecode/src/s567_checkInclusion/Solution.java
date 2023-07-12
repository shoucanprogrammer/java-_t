package s567_checkInclusion;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    @Test
    public void test(){
        checkInclusion("ab","eidboaoo");
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] fren = new int[26];
        for (int i = 0; i < s1.length(); i++){
            fren[s1.charAt(i)-'a'] ++;
        }
        Map<Character,Integer> map = new HashMap<>();
        int len = s1.length();
        int l = 0;
        int r = 0;
        while (r<s2.length()){
            char charR = s2.charAt(r);
            map.put(charR,map.getOrDefault(charR,0)+1);
            if (r-l == len -1){

                boolean fla = true;
                for (int i = 0; i  < s1.length(); i++){

                    if (!map.containsKey(s1.charAt(i))){
                        fla = false;
                    }else if (map.get(s1.charAt(i))< fren[s1.charAt(i)-'a']){
                        fla = false;
                    }
                }
                if (fla == true){
                    return fla;
                }
                char charL = s2.charAt(l);
                map.put(charL,map.getOrDefault(charL,0)-1);
                l++;

            }
            r++;
        }
        return false;
    }
}
