package s124_maxPathSum;
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        midSearch(root);
        return max;
    }
    public int midSearch(TreeNode  root){
        if (root == null){
            return 0;
        }
        int value = root.val;
        int left = Math.max(midSearch(root.left),0);
        int right = Math.max(midSearch(root.right),0);
        max = Math.max(left+right+value,max);
        return Math.max(left,right)+value;
    }
}
