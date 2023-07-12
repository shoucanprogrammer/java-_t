package s234_isPalindrome;

import org.junit.Test;

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
        isPalindrome(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1)))));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast.next != null&& fast.next.next !=null){  //找到中点
            slow = slow.next;
            fast = fast.next.next;
        }
        //找了中点
        while (slow.next != null){
            slow = slow.next;
            stack.push(slow.val);
        }
        ListNode cur = head;
        while (!stack.isEmpty()){
           if (cur.val != stack.pop()){
                return false;
           }
           cur = cur.next;
        }
        return true;
    }
}
