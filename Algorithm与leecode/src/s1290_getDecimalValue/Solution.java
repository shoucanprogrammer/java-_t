package s1290_getDecimalValue;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null){
            builder.append(temp.val);
            temp = temp.next;
        }
        return Integer.valueOf(builder.toString(),2);
    }
}
