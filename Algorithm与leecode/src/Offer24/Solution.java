package Offer24;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode tem = head;
        if (head == null){
            return null;
        }
        while (tem.next != null){
            //先把节点取出来
            ListNode cur = tem.next; //取出来的节点
            ListNode cur1 = cur.next;   //之后的节点
            tem.next = cur1;
            //把节点插入
            cur.next = dump.next;
            dump.next  = cur;
        }
        return dump.next;
    }
}
