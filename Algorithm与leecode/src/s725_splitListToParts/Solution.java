package s725_splitListToParts;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode tem = head;
        while (tem!= null){
            n++;
            tem =tem.next;
        }
        int quotient = n/k,remainder = n % k;
        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++){
            parts[i] = curr;
            int partSize = quotient + (i<remainder ? 1:0);
            for (int j = 1; j < partSize;j++){
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}
