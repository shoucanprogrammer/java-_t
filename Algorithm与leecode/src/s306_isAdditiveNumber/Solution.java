package s306_isAdditiveNumber;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    @Test
    public void test(){
        isAdditiveNumber("112358");
    }
    boolean flag = false;
    Deque<Long> steak1 = new ArrayDeque<>();
    Deque<Long> steak2 = new ArrayDeque<>();
    int num2 = 0;
    public boolean isAdditiveNumber(String num) {
        traceBack(num,0,1);
        return flag;
    }
    public void traceBack(String num, int n,int k){
        if (n == num.length()&&k > 3){
            flag = true;
            return ;
        }
        for (int i = n + 1; i < num.length()+1 ; i++){
            if (flag){
                return;
            }
            String substring = num.substring(n, i);
            if (substring.length() > 1 && substring.charAt(0) == '0'){   //不符合
                continue;
            }
            if (k == 1){//前两个数
                steak1.push(Long.valueOf(substring));
                traceBack(num,i,k+1);
            }
            if (k == 2){
               steak2.push(Long.valueOf(substring));
                traceBack(num,i,k+1);
            }
            if (k >= 3){
                //判断是否符合
                if (steak1.peek() + steak2.peek() == Long.valueOf(substring)){
                    steak1.push(steak2.peek());
                    steak2.push(Long.valueOf(substring));
                    if (i == 5){
                        System.out.println();
                    }
                    traceBack(num,i,k+1);
                    steak1.pop();
                    steak2.pop();
                }else {
                    continue;
                }
            }
        }
    }
}
