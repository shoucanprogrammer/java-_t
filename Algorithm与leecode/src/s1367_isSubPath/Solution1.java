package s1367_isSubPath;

public class Solution1 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null){
            return false;
        }
        return dfs(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    public boolean dfs(ListNode head, TreeNode root){
        if (head == null){
            return true;
        }else if (root == null){
            return false;
        }else if (root.val != head.val){
            return false;
        }
        return dfs(head.next,root.left) || dfs(head.next,root.right);
    }
}
