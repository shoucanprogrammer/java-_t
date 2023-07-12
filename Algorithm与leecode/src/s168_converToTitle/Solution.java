package s168_converToTitle;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        convertToTitle(701);
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0){
            int b = (columnNumber -1)% 26;
            columnNumber = (columnNumber -1)/26;
            builder.append((char)(b+'A'));
        }
        return builder.reverse().toString();
    }
}
