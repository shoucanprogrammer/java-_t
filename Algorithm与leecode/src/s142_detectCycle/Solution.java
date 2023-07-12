package s142_detectCycle;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    @Test
    public void test(){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        detectCycle(node1);
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur =head;
        Set<ListNode> set = new HashSet<>();
        while (cur!=null){
            if (!set.contains(cur)){
                set.add(cur);
                cur = cur.next;
            }else {
                return cur;
            }
        }
    return  null;
    }
}
