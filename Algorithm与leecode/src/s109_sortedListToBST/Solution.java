package s109_sortedListToBST;


import org.junit.Test;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    @Test
    public void test(){
        sortedListToBST(new ListNode(-10,new ListNode(-3,new ListNode(0,new ListNode(5,new ListNode(9))))));
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur.next != null){
            arrayList.add(cur.val);
            cur = cur.next;
        }
        arrayList.add(cur.val);
        int[] nums = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size();i++){
            nums[i] =  arrayList.get(i);
        }
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null){
            return null;
        }
        TreeNode root = inorderBuild(0, nums.length - 1, nums);
        return root;
    }

    public TreeNode inorderBuild(int left,int right,int[] nums){
        if (right<left){
            return null;
        }

        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorderBuild(left,mid-1,nums);
        root.right = inorderBuild(mid+1,right,nums);
        return root;
    }
}
