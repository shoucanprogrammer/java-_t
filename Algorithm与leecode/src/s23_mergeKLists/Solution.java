package s23_mergeKLists;


import org.testng.annotations.Test;

public class Solution {
    @Test
    public void test(){
        ListNode[] lists = new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))),
                new ListNode(1,new ListNode(3,new ListNode(4))),
                new ListNode(2,new ListNode(6)),
                new ListNode(3,new ListNode(3,new ListNode(4)))
        };
        ListNode[] lists1 = new ListNode[]{};
        ListNode[] lists2 = new ListNode[]{new ListNode()};
        ListNode list = mergeKLists(lists2);
        System.out.println();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        int len = lists.length;
        int start = 0;
        int end = len-1;
        ListNode listNode = Divide_Conquer(lists, start, end);
        return listNode;
    }
    public ListNode Divide_Conquer(ListNode[] lists,int start,int end){
        int mid = (start+end)/2;
        if (start==end){
            return lists[start];
        }
        if (end - start == 1){
            return mergeTwoLists(lists[start],lists[end]);
        }
        else {
            ListNode lf = Divide_Conquer(lists, start, mid);
            ListNode rt = Divide_Conquer(lists, mid + 1, end);
            return mergeTwoLists(lf,rt);
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}