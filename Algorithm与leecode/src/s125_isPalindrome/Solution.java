package s125_isPalindrome;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        isPalindrome1("0P");
    }
    public boolean isPalindrome(String s) {

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length();i++ ){
            if ('a'<=s.charAt(i)&&s.charAt(i)<='z'){
                buffer.append(s.charAt(i));
            }else if ('a'<=((int)s.charAt(i)+32)&&((int)s.charAt(i)+32)<='z'){
                buffer.append((char)((int)s.charAt(i)+32));
            }else if ('0'<=s.charAt(i)&&s.charAt(i)<='9'){
                buffer.append(s.charAt(i));
            }
        }
        String s1 = buffer.toString();
        if (s1.length()==0){
            return true;
        }

        int len = buffer.length();
        for (int i = 0;i < len; i++){
            int j = len-1-i;
            if (i == j||j<i){
                return true;
            }
            if (buffer.charAt(i) != buffer.charAt(j)){
                return false;
            }
        }
        return false;
    }


    public boolean isPalindrome1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }



}
