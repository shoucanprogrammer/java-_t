package s876_middleNode;

import org.junit.Test;

import java.util.List;

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
        middleNode(new ListNode(1,new ListNode(2,new ListNode(3))));
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 1;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            len++;
        }
        ListNode mid1 = slow;
        while (slow.next != null){
            slow = slow.next;
            len++;
        }
        return len % 2 == 0 ? mid1: mid1.next;
    }
}
