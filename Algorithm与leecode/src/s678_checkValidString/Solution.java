package s678_checkValidString;

import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack1  = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack1.push(i);
            }else if (c == '*'){
                stack2.push(i);
            }else if (c == ')'){
                if (!stack1.isEmpty()){
                    stack1.pop();
                }else {
                    if (!stack2.isEmpty()){
                        stack2.pop();
                    }else {
                        return false;
                    }
                }
            }

        }
        if (stack1.isEmpty()){
            return true;
        }else {
            if (stack2.size()<stack1.size()){
                return false;
            }
            while (!stack1.isEmpty()&&!stack2.isEmpty()){
                int leftIndex = stack1.pop();
                int asteriskIndex = stack2.pop();
                if (leftIndex>asteriskIndex){
                    return false;
                }
            }
            return true;
        }
    }
}
