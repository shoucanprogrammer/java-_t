package s19_removeNthFromEnd;

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
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode head1 = new ListNode(1,new ListNode(2));
        ListNode listNode = removeNthFromEnd(head1, 2);
        System.out.println();

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)
            return null;
        ListNode c = head;
        int len =1 ;
        while (c.next!=null){
            c=c.next;
            len++;
        }
        c = head;
        //如果只有头结点
        if (len==1)
            return null;
        int len1 =1;
        //删除头结点
        if (len==n)
            return head.next;
        while (c.next!=null){
            //如果删除非头结点的最后一个元素
            if (n==1){
                if (len1==len-1){
                    c.next = null;
                    return head;
                }
            }
            if (len-n==len1){
                ListNode tem = c.next.next;
                c.next = tem;
                return head;
            }
            c=c.next;
            len1++;
        }

        return c;
    }
}
