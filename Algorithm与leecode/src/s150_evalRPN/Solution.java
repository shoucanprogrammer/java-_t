package s150_evalRPN;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){

            if (tokens[i].equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                res = num2 + num1;
                stack.push(res);
            }else
            if (tokens[i].equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                res = num2 - num1;
                stack.push(res);
            }else
            if (tokens[i].equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                res = num2 * num1;
                stack.push(res);
            }else
            if (tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                res = num2 / num1;
                stack.push(res);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }

        }
    return stack.pop();
    }
}
