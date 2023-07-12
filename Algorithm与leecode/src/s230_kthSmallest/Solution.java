package s230_kthSmallest;

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
    private List<Integer> ans = new ArrayList<>();
    private int k1;

    public int kthSmallest(TreeNode root, int k) {
        k1= k;
        mid(root);
        return ans.get(k-1);
    }
    public void mid(TreeNode node){
        if (ans.size() >= k1 ){
            return;
        }
        if (node.left != null){
            mid(node.left);
        }
        ans.add(node.val);
        if (node.right != null){
            mid(node.right);
        }
    }
}
