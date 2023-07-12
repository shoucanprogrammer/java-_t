package s144_preorderTraversal;

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return ans;
        }
       pre(root);
        return ans;
    }

    public void pre(TreeNode root){
        if (root == null){
            return;
        }
        ans.add(root.val);
        pre(root.left);
        pre(root.right);
    }

}
