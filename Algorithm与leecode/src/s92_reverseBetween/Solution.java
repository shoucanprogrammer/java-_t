//package s92_reverseBetween;
//
//import org.junit.Test;
//
//public class Solution {
//     @Test
//     public void test(){
//          System.out.println(reverseBetween
//                  (new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2)))))),2,5));
//     }
//     public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//
//
//     }
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//          ListNode pre1 = null;
//          ListNode p1 = null;
//          ListNode p2 = null;
//          ListNode cur = head;
//          int count = 1;
//          while (true){
//               if (left == count){
//                    p1 = cur;
//               }
//               if (count == left-1){
//                    pre1 = cur;
//               }
//               if (count == right){
//                    p2 = cur;
//                    break;
//               }
//               count++;
//               cur = cur.next;
//          }
//          ListNode newList = null;
//          cur = p1;
//          newList = p2.next;
//          for (int i = 0; i <= right-left; i++){
//               newList  = new ListNode(cur.val, newList);
//               cur = cur.next;
//          }
//          if (left == 1){
//               return newList;
//          }else {
//               pre1.next = newList;
//               return head;
//          }
//
//     }
//}
