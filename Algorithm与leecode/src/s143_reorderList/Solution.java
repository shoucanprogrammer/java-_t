package s143_reorderList;

import org.junit.Test;

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
        reorderList(new ListNode(1,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(7))))));
    }
    public void reorderList(ListNode head) {
        if (head==null){
            return ;
        }
        ListNode mid = getMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        ListNode reverse = reverse(l2);
        merge(head,reverse);
    }
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null&&fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev; //反转
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public  void merge(ListNode list1,ListNode list2){
        ListNode list1Cur ;
        ListNode list2Cur ;
        while (list1!= null&&list2!= null){
            list1Cur = list1.next;
            list2Cur = list2.next;

            list1.next = list2;
            list1 = list1Cur;
            list2.next = list1;
            list2 = list2Cur;
        }

    }
}