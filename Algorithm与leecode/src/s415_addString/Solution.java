package s415_addString;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        addStrings("11","123");
    }
    public String addStrings(String num1, String num2) {
        int m = num1.length()-1;
        int n = num2.length()-1;
        int ans = 0;
        StringBuilder builder = new StringBuilder();
        while (m >= 0|| n >= 0){
            char c1 = m < 0 ? '0' : num1.charAt(m);
            char c2 = n < 0 ? '0' : num2.charAt(n);
            if (c1-'0'+c2-'0'+ans > 9){
                builder.append((char)(c1-'0'+c2-'0'+ ans - 10  + '0'));
                ans = 1;
            }else {
                builder.append((char)(c1-'0'+c2-'0'+ ans + '0'));
                ans = 0;
            }
            m--;
            n--;
        }
        if (ans == 1){
            builder.append('1');
        }
       return builder.reverse().toString();
    }
}
