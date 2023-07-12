package mianshi17_21;

import org.junit.jupiter.api.Test;

import java.awt.desktop.PreferencesEvent;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    @Test
    public void test(){

        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public int trap(int[] height) {
        //获取下一个大于等于的数组
        int n = height.length;
        int[] tem = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0 ; i < n; i++) {
            int num = height[i];
            while (!deque.isEmpty() && height[deque.peek()] <= num ){
                int pop = deque.pop();

                tem[pop] = num;
            }
            deque.push(i);
        }
        //获取下一个大于等于的数组

        int[] tem1 = new int[n];
        Deque<Integer> deque1 = new ArrayDeque<>();
        for (int i =  n - 1 ; i >= 0; i--) {
            int num = height[i];
            while (!deque1.isEmpty() && height[deque1.peek()] <= num ){
                int pop = deque1.pop();
                tem1[pop] = num;
            }
            deque1.push(i);
        }

        //像右
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (tem1[i] > max) {
                max = tem1[i];
            }
            tem1[i] = max;
        }

        max = 0;
        //向左
        for (int i = n - 1; i >= 0; i--) {
            if (tem[i] > max) {
                max = tem[i];
            }
            tem[i] = max;
        }
        //计算面积
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(tem[i],tem1[i]) > height[i] ? Math.min(tem[i],tem1[i]) - height[i] : 0;
        }
        return res;
    }
}
