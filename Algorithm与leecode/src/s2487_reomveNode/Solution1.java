package s2487_reomveNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution1 {
    public ListNode removeNodes(ListNode head) {
        ListNode tem = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (tem != null){
            while (!stack.isEmpty()&& tem.val > stack.peek().val){
                stack.pop();
            }
            stack.push(tem);
            tem = tem.next;
        }
        ListNode dum = new ListNode(0);
        tem = dum;
        while (!stack.isEmpty()){
            tem.next = stack.pollLast();
            tem = tem.next;
        }
    return dum.next;
    }
}
