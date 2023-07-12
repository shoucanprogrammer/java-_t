package s1456_maxVowels;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        maxVowels("abciiidef",3);
    }
    public int maxVowels(String s, int k){
        int count = 0;
        int max = 0;
        for (int i = 0; i < k; i++){
            if (s.charAt(i) == 'a'){
                count++;
            }else if (s.charAt(i) == 'e'){
                count++;
            }else if (s.charAt(i) == 'i'){
                count++;
            }else if (s.charAt(i) == 'o'){
                count++;
            }else if (s.charAt(i) == 'u'){
                count++;
            }
        }
        max = Math.max(max,count);
        for (int i = 1 ; i < s.length() - k + 1; i++){
            if (s.charAt(i-1) == 'a'){
                count--;
            }else if (s.charAt(i-1) == 'e'){
                count--;
            }else if (s.charAt(i-1) == 'i'){
                count--;
            }else if (s.charAt(i-1) == 'o'){
                count--;
            }else if (s.charAt(i-1) == 'u'){
                count--;
            }
            if (s.charAt(i + k - 1) == 'a'){
                count++;
            }else if (s.charAt(i+ k - 1) == 'e'){
                count++;
            }else if (s.charAt(i+ k - 1) == 'i'){
                count++;
            }else if (s.charAt(i+ k - 1) == 'o'){
                count++;
            }else if (s.charAt(i+ k - 1) == 'u'){
                count++;
            }
            max = Math.max(max,count);
        }
    return max;
    }
}
