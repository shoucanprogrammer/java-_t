package s82_deleteDuplicates;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        deleteDuplicates(new ListNode(1,new ListNode(1,new ListNode(1))));
    }
    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        //双指针
        ListNode p1 = dummy.next;
        ListNode p2 = dummy.next.next;
        ListNode list = dummy ;

        while (p2!=null){
            if (p1.val!=p2.val){
                list.next = p1;
                p1 = p1.next;
                p2 = p2.next;
                list = list.next;
            }else {
                while (p2!=null&&p1.val==p2.val){
                   p2 = p2.next;
                }
                if (p2 == null){
                    list.next = null;
                    return dummy.next;
                }
                p1 = p2;
                p2 = p1.next;
                if (p2 == null){
                    list.next = p1;
                }
            }
        }
        return dummy.next;
    }

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
