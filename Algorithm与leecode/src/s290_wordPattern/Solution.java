package s290_wordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern,String str){
        String[] words = str.split("");
        //字符和单次是互相映射，数量必须相等
        if (words.length != pattern.length()){
            return false;
        }
        Map<String,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if (map2.put(pattern.charAt(i),i) !=  map1.put(words[i],i)){
                return false;
            }
        }
        return true;
    }
}
