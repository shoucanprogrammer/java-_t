package s145_postorderTraversal;


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }

    public void postorder(TreeNode node,List<Integer> list){
        if (node == null){
            return;
        }
        if (node.left != null){
            postorder(node.left,list);
        }
        if (node.right != null){
            postorder(node.right,list);
        }
        list.add(node.val);
    }
}
