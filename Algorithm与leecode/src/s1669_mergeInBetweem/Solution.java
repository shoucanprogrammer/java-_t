package s1669_mergeInBetweem;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tem1 = list1;
        while (a > 1){
            tem1 = tem1.next;
            a--;
            b--;
        }
        ListNode tem2 = tem1;
        while (b > 0){
            tem2 = tem2.next;
            b--;
        }
        tem1.next = list2;
        while (tem1 !=null && tem1.next != null){
            tem1 =tem1.next;
        }
        tem1.next = tem2.next;
        return list1;
    }
}
