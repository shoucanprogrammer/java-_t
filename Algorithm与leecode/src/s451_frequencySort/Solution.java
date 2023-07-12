package s451_frequencySort;

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++){
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c,0)+1;
            map.put(c,frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++){
            char c = list.get(i);
            for (int j = 0; j < map.get(c); j++){
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
//class Solution {
//    public String frequencySort(String s) {
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            int frequency = map.getOrDefault(c, 0) + 1;
//            map.put(c, frequency);
//        }
//        List<Character> list = new ArrayList<Character>(map.keySet());
//        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
//        StringBuffer sb = new StringBuffer();
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            char c = list.get(i);
//            int frequency = map.get(c);
//            for (int j = 0; j < frequency; j++) {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
//}
//
