package s316_removeDuplicateLetters;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    @Test
    public void test(){
        removeDuplicateLetters("ecbacba");
    }
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastOp = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++){
            lastOp[chars[i] - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (visited[chars[i] - 'a']) { //如果出现舍弃当前字符
                continue;
            }
            while (!stack.isEmpty()&& stack.peek() > chars[i] && lastOp[stack.peek()-'a']>i){
                Character ch = stack.pop();
                visited[ch-'a'] = false;
            }
            stack.push(chars[i]);
            visited[chars[i] -'a'] = true;
        }
        String s1 = "";
        int size = stack.size();
        for (int i = 0; i < size; i++){
            s1 = String.valueOf(stack.pop())+s1 ;
        }
        return s1;
    }
}
