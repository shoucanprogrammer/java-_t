package s24_swapPairs;

import org.testng.annotations.Test;

import java.util.List;

public class Solution {
    @Test
    public void test(){
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode listNode1 = new ListNode();
        swapPairs(listNode1);
    }
    public ListNode swapPairs(ListNode head){
        if (head==null){
            return head;
        }else if (head.next == null){
            return head;
        }else if (head.next != null){
            ListNode temp;
            temp = head.next.next;
            head.next.next = head;
            head = head.next;
            head.next.next = swapPairs(temp);
            return head;
        }

        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
