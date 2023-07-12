package s623_addOneRow;

import greedy.Test;

import java.util.LinkedList;
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            return new TreeNode(val,root,null);
        }
        int h = 2;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (h < depth){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            h++;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++){
            TreeNode node = queue.poll();
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);

        }
        return root;
    }
}
