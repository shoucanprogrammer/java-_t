package s227_calculate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    @Test
    public void test(){
        calculate("1*2-3/4+5*6-7*8+9/10");
    }
    public int calculate(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>() {{
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }};
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                int k = i;
                while (k< s.length()&&Character.isDigit(s.charAt(k))){
                    k++;
                }
                String substring = s.substring(i, k);
                nums.push(Integer.valueOf(s.substring(i,k)));
                i = k-1;
            }
            if (!Character.isDigit(s.charAt(i))&&s.charAt(i)!= ' '){
                while (!op.isEmpty()&& map.get(s.charAt(i)) <= map.get(op.peek())){
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    int op1 = op.pop();
                    int res = 0;
                    if (op1 == '+'){
                        res = num1 + num2;
                    }
                    if (op1 == '-'){
                        res = num2 - num1;
                    }
                    if (op1 == '*'){
                        res = num2 * num1;
                    }
                    if (op1 == '/'){
                        res = num2 / num1;
                    }
                    nums.push(res);
                }
                if (s.charAt(i) != ' ')
                    op.push(s.charAt(i));
            }
        }
        while (!op.isEmpty()){
            int num1 = nums.pop();
            int num2 = nums.pop();
            int op1 = op.pop();
            int res = 0;
            if (op1 == '+'){
                res = num1 + num2;
            }
            if (op1 == '-'){
                res = num2 - num1;
            }
            if (op1 == '*'){
                res = num2 * num1;
            }
            if (op1 == '/'){
                res = num2 / num1;
            }
            nums.push(res);
        }
        return nums.pop();
    }
}
