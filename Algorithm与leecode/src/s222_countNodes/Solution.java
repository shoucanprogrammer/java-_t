package s222_countNodes;
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
    public int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
