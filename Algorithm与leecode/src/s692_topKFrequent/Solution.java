package s692_topKFrequent;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null){
            return null;
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });

        return list.subList(0,k);
    }
}
