package s224_calculate;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    @Test
    public void test(){
        calculate(" (1+(4+5+2)-3)+(6+8)");
    }
    HashMap<Character,Integer> map = new HashMap<Character,Integer>(){
        {
            put('+', 1);
            put('-', 1);
            put('(',2);
            put(')',2);
        }
    };
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.replace(" ", "");
        s = s.replace("(-","(0-");
        s = s.replace("(+","(0+");
        nums.push(0);
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i)=='('){
                ops.push(s.charAt(i));

            }else if (s.charAt(i)==')'){
                //计算操作
                while (ops.peek()!='('){
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    int op = ops.pop();
                    int res = 0;
                    if (op == '+'){
                        res = num2 + num1;
                    }else if (op == '-'){
                        res = num2 - num1;
                    }
                    nums.push(res);
                }
                ops.pop();
            }else if (Character.isDigit(s.charAt(i))){
                int k = i;
                while (k<s.length()&&Character.isDigit(s.charAt(k))){
                    k++;
                }
                nums.push(Integer.valueOf(s.substring(i,k)));
                i = k -1;
            }else {  //操作符

                while (!ops.isEmpty()&&ops.peek()!='('&&map.get(s.charAt(i))<=map.get(ops.peek())){
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    int op = ops.pop();
                    int res = 0;
                    if (op == '+'){
                        res = num2 + num1;
                    }else if (op == '-'){
                        res = num2 - num1;
                    }
                    nums.push(res);
                }
                ops.push(s.charAt(i));
            }
        }
        while (!ops.isEmpty()){
            int num1 = nums.pop();
            int num2 = nums.pop();
            int op = ops.pop();
            int res = 0;
            if (op == '+'){
                res = num2 + num1;
            }else if (op == '-'){
                res = num2 - num1;
            }
            nums.push(res);
        }
        return nums.pop();
    }
}
