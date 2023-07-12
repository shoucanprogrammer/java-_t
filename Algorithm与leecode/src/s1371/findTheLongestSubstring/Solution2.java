package s1371.findTheLongestSubstring;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    @Test
    public void test(){
        findTheLongestSubstring("leetcodeisgreat");
    }
    public int findTheLongestSubstring(String s) {
        int res = 0;
        int state = 0;
        Map<Character, Integer> vowel = new HashMap<>();
        vowel.put('u', 16);
        vowel.put('o', 8);
        vowel.put('i', 4);
        vowel.put('e', 2);
        vowel.put('a', 1);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // 只有在遇到元音的时候，state的状态才会改变，才有可能要存
            // 只存一个状态第一次出现时候的index
            if (vowel.containsKey(arr[i])) {
                state = state ^ vowel.get(arr[i]);
                if (!map.containsKey(state)) {
                    map.put(state, i);
                }
            }
            // 遇到的不是元音的话，state是不会改变的，之前肯定已经存下了这个状态（已知）
            res = Math.max(res, i - map.get(state));
        }
        return res;
    }
}
