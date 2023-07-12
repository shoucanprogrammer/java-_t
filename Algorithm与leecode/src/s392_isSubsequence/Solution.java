package s392_isSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while (left < s.length() && right < t.length()){
            if (s.charAt(left) == t.charAt(right)){
                left++;
                right++;
            }  else {
                right++;
            }
        }
        if (left == s.length()){
            return true;
        }else {
            return false;
        }
    }
}
