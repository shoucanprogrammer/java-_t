package s139_wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int r = 1; r <= s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (dp[l] && wordDictSet.contains(s.substring(l, r))) {
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
