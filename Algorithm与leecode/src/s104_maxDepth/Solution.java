package s104_maxDepth;

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

    public int maxDepth(TreeNode root) {
        int h = middle_order(root, 0);
        return h;
    }
    public int middle_order(TreeNode root, int h){
        if (root==null){
            return h;
        }
        int hleft = middle_order(root.left, h + 1);
        int hright = middle_order(root.right, h + 1);
        return Math.max(hleft,hright);
    }
}
