package s1448_goodNodeds;
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
    public int goodNodes(TreeNode root) {
        int ans = preSearch(root, Integer.MIN_VALUE);
        return ans;
    }
    public int preSearch(TreeNode root,int max){
        int ret = 0;
        if (root.val >= max){
            ret++;
            ret += preSearch(root.left, root.val);
            ret += preSearch(root.right, root.val);
        }else {
            ret += preSearch(root.left, max);
            ret += preSearch(root.right, max);
        }
        return ret;
    }
}
