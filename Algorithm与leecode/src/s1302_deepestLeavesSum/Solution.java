package s1302_deepestLeavesSum;

import org.junit.Test;

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
    @Test
    public void test(){
        deepestLeavesSum(new TreeNode(1,new TreeNode(2),new TreeNode(3)));
    }
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return 0;
        }
        int sum = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }
}
