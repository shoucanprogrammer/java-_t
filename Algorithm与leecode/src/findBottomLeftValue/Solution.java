package findBottomLeftValue;

import java.util.Deque;
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode node = queue.poll();
            if (node.right != null){
                queue.offer(node.right);
            }
            if (node.left!= null){
                queue.offer(node.left);
            }
            ans = node.val;
        }

        return ans;
    }
}
