package OfferII027_isPalindrome;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Solution {
    @Test
    public void test(){
        isPalindrome(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1)))));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow= slow.next;
        }
        slow = slow.next;
        Deque<Integer> deque = new ArrayDeque<>();
        while (slow != null){
           deque.push(slow.val);
           slow= slow.next;
        }
        slow = head;
        while (!deque.isEmpty()){
            if (deque.pop()!= slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
