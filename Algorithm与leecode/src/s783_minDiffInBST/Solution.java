package s783_minDiffInBST;
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
    int pre = -1;
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(root.val - pre,ans);
            pre = root.val;
        }
        dfs(root.right);
    }

}
