package s543_diameterOfBinaryTree;
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = midSearch(root);
        return max-1;
    }
    public int midSearch(TreeNode root){
        if (root == null){
            return 0;
        }
        int h = 1;
        int lefth = midSearch(root.left);
        int righth = midSearch(root.right);
        h = h + lefth + righth;
        max  =Math.max(h,max);
        return Math.max(lefth,righth)+1;
    }
}
