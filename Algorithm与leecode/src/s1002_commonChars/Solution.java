package s1002_commonChars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    @Test
    public void test(){
        commonChars(new String[]{"label","label"});
    }
    public List<String> commonChars(String[] words) {

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++){
            map1.put(words[0].charAt(i),map1.getOrDefault(words[0].charAt(i),0)+1);
        }
        for (int i = 1; i < words.length; i++){
            Map<Character, Integer> map2 = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++){
                if (map1.containsKey(words[i].charAt(j))){
                    map2.put(words[i].charAt(j),Math.min(map2.getOrDefault(words[i].charAt(j),0)+1,map1.get(words[i].charAt(j))));
                }
            }
            map1 = map2;

        }
        List<String> ans = new ArrayList<>();
        for (Character c : map1.keySet()) {
            int num = map1.get(c);
            for (int i = 0; i < num; i++) {
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }
}
