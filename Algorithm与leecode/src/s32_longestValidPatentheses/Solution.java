package s32_longestValidPatentheses;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
public class Solution {
    @Test
    public void test(){
        longestValidParentheses("(()");
    }
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || len ==1)
            return 0;
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < len; i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
              stack.pop();
              if (stack.isEmpty()){
                  stack.push(i);
              }else {
                  Integer peek = stack.peek();
                  max = Math.max(max, i - stack.peek());
              }
            }
        }
        return max;
    }
}