package s160_getIntersectionNode;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode Pa = headA;
        ListNode Pb = headB;
        while (Pa != Pb){
            Pa = Pa == null ? headB : Pa.next;
            Pb = Pb == null ? headA :Pb.next;
        }
        return Pa;
    }
}
