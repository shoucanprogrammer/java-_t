package s20_isValid;

import org.junit.Test;

import java.util.Stack;
public class Solution {
    @Test
    public void test(){
        boolean valid = isValid("]");
        System.out.println();

    }
    public boolean isValid(String s){
        Stack<Character>  stack= new Stack();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            if (s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){

                if (stack.empty()){
                    return false;
                }
                Character pop = '0';
                if (!stack.empty()){
                    pop = stack.pop();
                }
                if (s.charAt(i)==')'){
                    if (pop != '(')
                        return false;
                }else if (s.charAt(i)==']'){
                        if (pop != '[')
                        return false;
                }else if (s.charAt(i)=='}'){
                        if (pop != '{')
                            return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
