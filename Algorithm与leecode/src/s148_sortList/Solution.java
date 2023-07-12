package s148_sortList;

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
        sortList(new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3)))));
    }

    public ListNode sortList(ListNode head) {
        ListNode dump = new ListNode(0,head);
        ListNode cur ;
        ListNode before = dump;
        ListNode left = dump;
        ListNode after ;
        while (left!=null){
            cur = left.next;
            while (cur!= null&&cur.next!=null){
                if (cur.next.val< left.next.val){
                    before = cur;
                    after = cur.next.next;
                    cur.next.next = left.next;
                    left.next = cur.next;
                    before.next = after;
                    cur = left.next;
                }else {
                    cur = cur.next;
                }

            }
            left = left.next;
        }

        return dump.next;
    }
}
