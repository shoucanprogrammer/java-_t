package s402_removeKdigits;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//public class Solution {
//    @Test
//    public void test(){
//        removeKdigits("10001",4);
//    }
//    public String removeKdigits(String num, int k) {
//        int t = 0;
//        if (num.length() <= k){
//            return "0";
//        }
//        for (int r = 1; r < num.length(); r++){
//            int l = r - 1;
//            if (num.charAt(l) > num.charAt(r)&&num.charAt(l)!='0'){
//                 num = num.replaceFirst(String.valueOf(num.charAt(l)),"");
//                 r=r-2;
//                 if (r<0){
//                     r = 0;
//                 }
//                t++;
//                if (t == k){
//                    break;
//                }
//            }
//        }
//        while (t < k){
//            int len = num.length();
//            num = num.replaceFirst(String.valueOf(num.charAt(len-1)), "");
//            t++;
//        }
//        //去掉前导
//
//        while (num.charAt(0)=='0'&&num.length()>1){
//            num = num.replaceFirst(String.valueOf(num.charAt(0)), "");
//        }
//
//        return num;
//    }
//}


class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) { //最后最大删除
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}

