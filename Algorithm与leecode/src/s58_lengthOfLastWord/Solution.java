package s58_lengthOfLastWord;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        int hello = lengthOfLastWord("Hello vll ");
        System.out.print(1);
    }
    public int lengthOfLastWord(String s){
        int length = s.length();
        int rea = 0;
        //去掉空格
        while (s.charAt(length-1) == ' '){
            length--;
        }
        rea = length;
        while (length>0&&s.charAt(length-1) != ' '){
            length--;
        }
    return rea-length;
    }
}
