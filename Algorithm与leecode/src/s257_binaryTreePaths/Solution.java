package s257_binaryTreePaths;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    private List<String> listSum = new ArrayList<>();
    private StringBuffer buffer = new StringBuffer();
    private Queue path = new ArrayDeque();
    public List<String> binaryTreePaths(TreeNode root) {
        preOrder(root);
        return listSum;
    }
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null&&root.right==null){
            buffer.append(root.val);
            listSum.add(new StringBuffer(buffer.toString()).toString());
            buffer.delete(buffer.length()-String.valueOf(root.val).length(),buffer.length());
            return;

        }
        buffer.append(root.val);
        buffer.append("->");
        //左子树
        preOrder(root.left);
        preOrder(root.right);
        buffer.delete(buffer.length()-String.valueOf(root.val).length()-2,buffer.length());
    }
}
