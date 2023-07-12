package s2487_reomveNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode tem = head;
        HashMap map = new HashMap<ListNode,ListNode>();
        Deque<ListNode> stack = new ArrayDeque<>();
        while (tem != null){
            while (!stack.isEmpty()&& tem.val > stack.peek().val){
                map.put(stack.pop(),tem);
            }
            stack.push(tem);
            tem = tem.next;
        }
        tem = head;
        ListNode dum = new ListNode(0);
        ListNode newTem = dum;
        while (tem != null){
            if (!map.containsKey(tem)){
                newTem.next = tem;
                newTem = newTem.next;
            }
            tem = tem.next;
        }
        return dum.next;
    }
}
