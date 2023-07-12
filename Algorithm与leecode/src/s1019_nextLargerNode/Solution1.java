package s1019_nextLargerNode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution1 {
    @Test
    public void test(){
        nextLargerNodes(new ListNode(1,new ListNode(4,new ListNode(2,new ListNode(5)))));
    }
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<int[]> stack = new ArrayDeque<int[]>();

        ListNode cur = head;
        int idx = -1;
        while (cur != null) {
            ++idx;
            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                ans.set(stack.pop()[1], cur.val);
            }
            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
