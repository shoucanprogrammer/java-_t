package s1371.findTheLongestSubstring;

import org.junit.Test;

import java.util.HashSet;

public class Solution {
    @Test
    public void test(){
        findTheLongestSubstring("leetcodeisgreat");
    }
    public int findTheLongestSubstring(String s) {
        int n = s.length();

        int ans = 0;
        for (int i = 0; i < n; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < n; j++){
                if (j == 13){
                    int b = 0;
                }
                char c = s.charAt(j);
                if (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
                    if (set.contains(c)){
                        set.remove(c);
                    }else {
                        set.add(c);
                    }
                }
                if (set.isEmpty()){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
