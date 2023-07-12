package s445_addTwoNumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

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
        addTwoNumbers(new ListNode(4),new ListNode(5));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }
        ListNode ans = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur1 = a + b + carry;
            carry = cur1 / 10;
            cur1 %= 10;
            ListNode curnode = new ListNode(cur1);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
