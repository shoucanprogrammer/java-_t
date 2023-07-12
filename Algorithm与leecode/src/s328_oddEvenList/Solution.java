package s328_oddEvenList;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oneList = head;
        ListNode twoHead= head.next;
        ListNode  twoList = twoHead;
        while (twoList!= null && twoList.next!=null ){
            oneList.next = twoList.next;
            oneList = oneList.next;
            twoList.next = oneList.next;
            twoList = twoList.next;
        }
        oneList.next = twoHead;
        return head;
    }
}
