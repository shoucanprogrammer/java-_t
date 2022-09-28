package s25_reverseKGroup;

import org.junit.Test;
public class Solution {
    @Test
    public void test(){
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode2 = reverseKGroup(listNode, 3);
        System.out.println();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        int len = 1;

        ListNode cur = head;
        //找到第k个元素
        while (cur.next!= null && len < k){
            cur = cur.next;
            len++;
        }
        if (len < k)
            return head;
        ListNode cur1 = cur;
        ListNode cur2 = cur.next;
        //cur为第k个结点
        for (int i = len - 2; i >0; i--){
            int j = i;
            ListNode temp = head;
            while (j>0){
                temp = temp.next;
                j--;
            }
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = head;
        cur.next.next = reverseKGroup(cur2, k);
        return cur1;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
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
