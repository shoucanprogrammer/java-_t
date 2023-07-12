package s437_pathSum;
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }
    public int rootSum(TreeNode root, int targetSum){
        int ret = 0;
        if (root == null){
            return ret;
        }


        if (root.val== targetSum){
            ret++;
        }
        ret += rootSum(root.left,targetSum- root.val);
        ret += rootSum(root.right,targetSum- root.val);
        return ret;
    }
}
