package s865_subtreeWithAllDeepest;
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
class Solution {
    private TreeNode ans;
    private int max;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 1);
        return ans;
    }
    private int dfs(TreeNode node, int depth) { //先序遍历
        if (node == null) return 0;
        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);

        if (depth > max) {
            max = depth;
        }
        if (depth == max || (left == max && right == max)) {
            ans = node;
        }
        return Math.max(left, Math.max(depth, right));
    }
}