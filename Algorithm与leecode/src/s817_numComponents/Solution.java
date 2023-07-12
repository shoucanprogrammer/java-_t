package s817_numComponents;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int ans = 0;
        ListNode tem = head;
        boolean fla = false;
        while (tem != null){
            if (set.contains(tem.val)){
                fla = true;
            }else {
                if (fla == true){
                    ans ++;
                }
                fla = false;
            }
            tem = tem.next;
        }
       return fla == true ? ans+1 : ans;

    }
}
