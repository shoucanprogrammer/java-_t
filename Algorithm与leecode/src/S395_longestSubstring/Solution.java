package S395_longestSubstring;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        longestSubstring("aaabb",3);
    }
    public int longestSubstring(String s, int k) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++){
            int[] counter = new int[26];
            for (int j = i; j < s.length(); j++){
                counter[s.charAt(j)-'a']++;
                boolean fla = true;
                for (int m = 0; m< 26; m++){
                    if (counter[m]!=0 && counter[m]<k){
                        fla = false;
                        break;
                    }
                }
                if (fla){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
