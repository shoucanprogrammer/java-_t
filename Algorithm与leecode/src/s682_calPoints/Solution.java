package s682_calPoints;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++){
            if (operations[i].equals("C") ){
                stack.pop();
            }else if (operations[i].equals("D")){
                stack.push(stack.peek()*2);
            }else if (operations[i].equals("+") ){
                int  num1 = stack.pop();
                int  num2 = stack.peek();
                stack.push(num1);
                stack.push(num1+num2);
            }else {
                stack.push(Integer.valueOf(operations[i]));
            }
        }
        int size = stack.size();
        int ans = 0;
        for (int i = 0; i < size; i++){
            ans += stack.pop();
        }
        return ans;
    }
}
