package s86_partition;

import org.junit.Test;


public class solution {
    @Test
    public void test(){
//        partition(new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2)))))),3);
        partition(null,0);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode dumpy = new ListNode(0,head);
        //寻找插入点
        ListNode p1 = null;
        ListNode cur2 = dumpy;
        ListNode cur = null;
        while (cur2.next!=null){
            if (cur2.next.val >= x){
                p1 = cur2;
                cur = p1.next;
                break;
            }
            cur2 = cur2.next;
        }

        ListNode cur1 ;
        if (cur == null){
            return head;
        }
        while (cur.next!=null){
            if (cur.next.val < x){
                //插入换位
                cur1 = cur.next;
                cur.next = cur.next.next;
                cur1.next = p1.next;
                p1.next = cur1;
                p1 = cur1;


            }else {
                cur = cur.next;
            }
        }
        return dumpy.next;
    }
}
