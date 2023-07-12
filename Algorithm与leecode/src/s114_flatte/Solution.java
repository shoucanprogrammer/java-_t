package s114_flatte;

import org.junit.Test;

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
    @Test
    public void test(){
        flatten(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6))));
    }
    private TreeNode newTree = new TreeNode(0) ;
    TreeNode cur = newTree;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        preOrder(root);
        root.left = null;
        root.right = newTree.right.right;

    }
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        cur.right = new TreeNode(root.val);
        cur = cur.right;
       preOrder(root.left);
       preOrder(root.right);
    }
    public void flatten1(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


}