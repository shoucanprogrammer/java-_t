package s92_reverseBetween;

import org.junit.Test;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution2 {
    @Test
    public void test(){
        System.out.println(reverseBetween
                (new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2,4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre1 = null;
        ListNode cur = head;
        ListNode pre = null;
        ListNode p1 = null;
        ListNode p2 = null;
        int count = 1;
        while (count <= right){
            if (count == left){
                    p1 = cur;
               }
            if (count == left-1){
                pre1 = cur;
            }
            if (count >= left && count <= right){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if (count < left){
                cur = cur.next;
            }
            count++;
        }
        if (pre1 == null) {
            p1.next = cur;
            return pre;
        }
        pre1.next = pre;
        p1.next = cur;
        return head;

    }
}

