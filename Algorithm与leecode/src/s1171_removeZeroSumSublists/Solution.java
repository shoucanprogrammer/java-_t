package s1171_removeZeroSumSublists;

import org.junit.Test;

import java.util.HashMap;

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
        removeZeroSumSublists(new ListNode(1,new ListNode(2,new ListNode(-3,new ListNode(3,new ListNode(1))))));
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode tem = dump;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (tem != null){
            sum += tem.val;
            map.put(sum,tem);
            tem = tem.next;
        }
        tem = dump;
        sum = 0;
        while (tem != null){
            sum += tem.val;
            tem.next = map.get(sum).next;
            tem = tem.next;
        }
        return dump.next;
    }
}
