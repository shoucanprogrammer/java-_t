package s_findRepeatedDnaSequences;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test() {
        findRepeatedDnaSequences("AAAAAAAAAAA");
    }

    //    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> list = new ArrayList<>();
//        Map<Character, Integer> map = new HashMap<>();
//        int l = 0;
//        int r = 0;
//        int len = 10;
//        while (r < s.length()){  //右移
//             if (!map.containsKey(s.charAt(r))){ //不存再  存入
//                 map.put(s.charAt(r),1);
//             }else {
//                 map.replace(s.charAt(r), map.get(s.charAt(r))+1);  //存在加1
//             }
//             r++;
//
//             if (r-l==len){ //存满了
//                 boolean fla  = true;//判断条件
//                 if (map.containsKey('A') && map.get('A')<2){
//                     fla = false;
//                 }
//                 if (map.containsKey('C') && map.get('C')<2){
//                     fla = false;
//                 }
//                 if (map.containsKey('G') && map.get('G')<2){
//                     fla = false;
//                 }
//                 if (map.containsKey('T') && map.get('T')<2){
//                     fla = false;
//                 }
//
//                 //判断是否满足条件
//                 if (fla){
//                     list.add((String) s.subSequence(l,r));
//                     map.replace(s.charAt(l), map.get(s.charAt(l)) -1);
//                     l++;
//                 }else {//不满足条件
//                     map.replace(s.charAt(l), map.get(s.charAt(l)) -1);
//                     l++;
//                 }
//             }
//
//        }
//        return list;
//    }
//}
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String,Integer> set = new HashMap<>();

        Map<String, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = 10;
        while (r <= s.length()) {  //右移
            if (r - l == len) { //存满了
                String sub = s.substring(l,r);
                set.put(sub,set.getOrDefault(sub, 0) + 1);
                if (set.get(sub)==2){
                    list.add(sub);
                }
                l++;
                }
            r++;
        }
        return list;
    }
}