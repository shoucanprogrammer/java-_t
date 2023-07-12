package offer015_findAnagrams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    @Test
    public void test(){
        findAnagrams("cbaebabacd","abc");
    }
    public List<Integer> findAnagrams(String s, String p){
        if (p.length() > s.length()){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < p.length(); i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
            }else {
                map.put(s.charAt(i),-1);
            }
            if (map.get(s.charAt(i)) == 0){
                map.remove(s.charAt(i));
            }

        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() == 0){
                map.remove(entry.getKey());
            }
        }
        if (map.size() == 0){
            list.add(0);
        }
        for (int i = 1; i < s.length()-p.length()+1; i++){
            map.put(s.charAt(i+p.length()-1),map.getOrDefault(s.charAt(i+p.length()-1),0)-1);
            if (map.containsKey(s.charAt(i-1))){
                map.put(s.charAt(i-1),map.get(s.charAt(i-1))+1);
            }else {
                map.put(s.charAt(i-1),1);
            }

            if (map.get(s.charAt(i-1)) == 0){
                map.remove(s.charAt(i-1));
            }
            for (Map.Entry<Character,Integer> entry : map.entrySet()){
                if (entry.getValue() == 0){
                    map.remove(entry.getKey());
                }
            }
            if (map.size()==0){
                list.add(i);
            }
        }

    return list;
    }
}
