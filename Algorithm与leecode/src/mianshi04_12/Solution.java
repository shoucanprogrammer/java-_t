package mianshi04_12;

import com.sun.source.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    int n = 0;
    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        n += preSearch(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return n;
    }
    public int preSearch(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        sum = sum - root.val;
        if (sum == 0){
            ret++;
        }
        ret += preSearch(root.left, sum);
        ret += preSearch(root.right, sum);
        return ret;
    }
}
