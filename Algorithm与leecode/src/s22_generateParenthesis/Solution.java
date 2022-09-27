package s22_generateParenthesis;

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n-1)) {
            for (int i = 0; i < 2*n-2; i++) {
                hs.add(s.substring(0,i) + "()" + s.substring(i,s.length()));
            }
        }
        return new ArrayList(hs);
    }
}