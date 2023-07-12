package offer22;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tem = head;
        ListNode slow = head;
        while (tem.next!=null){
            if (k >= 0){
                k --;
                tem =tem.next;
            }else {
                tem =tem.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
