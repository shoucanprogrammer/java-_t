package s1019_nextLargerNode;

import org.junit.Test;

import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
    @Test
    public void test(){
        nextLargerNodes(new ListNode(1,new ListNode(8,new ListNode(2,new ListNode(5)))));
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode tem = head;
        Deque<int[]> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        while (tem != null){
            ans.add(0);
            while (!deque.isEmpty() && deque.peekFirst()[1] < tem.val){
                ans.set(deque.pollFirst()[0],tem.val);
            }

            deque.addFirst(new int[]{index,tem.val});
            tem = tem.next;
            index ++;
        }
        int[] ans1 = new int[index];
        int size = ans.size();
        for (int i = 0; i < index; i ++){
            ans1[i] = ans.get(i);
        }

        return ans1;
    }
}
