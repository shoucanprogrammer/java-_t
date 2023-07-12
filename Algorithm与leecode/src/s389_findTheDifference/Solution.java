package s389_findTheDifference;

import java.util.Arrays;

public class Solution {
    public char findTheDifference(String s, String t) {
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++){
            num1[s.charAt(i)-'a']++;
            num2[t.charAt(i)-'a']++;
        }
        num2[t.charAt(len)-'a']++;
        for (int i = 0; i < 26; i++){
            if (num1[i] != num2[i]){
                return (char) (i+'a');
            }
        }
        return 'a';
    }
}
