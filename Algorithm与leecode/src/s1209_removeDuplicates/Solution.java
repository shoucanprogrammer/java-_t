package s1209_removeDuplicates;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    @Test
    public void test(){
        removeDuplicates("abcd",2);
    }
    public String removeDuplicates(String s, int k) {
        Deque<Character> letter = new ArrayDeque<>();
        Deque<Integer> num = new ArrayDeque<>();
        int n = s.length();
        letter.push(s.charAt(0));
        num.push(1);
        int k1;
        for (int i = 1; i < n; i++){
            if (!letter.isEmpty()&&letter.peek() == s.charAt(i)){
                k1 = num.peek()+1;
            }else {
                k1 = 1;
            }
            if (k1 < k){
                letter.push(s.charAt(i));
                num.push(k1);
            }else {
                while (!letter.isEmpty()&&letter.peek()==s.charAt(i)){
                    num.pop();
                    letter.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        int size = letter.size();
        for (int i = 0; i < size; i++){
                builder.append(letter.pollLast());
        }
        return builder.toString();
    }
}
