package s49_groupAnagrams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap stringHashMap = new HashMap<String,ArrayList<String>>();
        for (String str :strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ArrayList<String> list = (ArrayList<String>) stringHashMap.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            stringHashMap.put(key,list);
        }
        return new ArrayList<List<String>>(stringHashMap.values());

    }
}
