package s237_deleteNode;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next;
    }
}
