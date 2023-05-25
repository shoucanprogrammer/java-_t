package S395_longestSubstring;

public class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++){
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
            counter[s.charAt(i)-'a']--;
        }
        return ans;
    }
}
