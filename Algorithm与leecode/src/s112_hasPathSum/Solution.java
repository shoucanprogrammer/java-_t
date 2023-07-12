package s112_hasPathSum;


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
    class TH{
        TreeNode root;
        int hight;

        public TH(TreeNode root, int hight) {
            this.root = root;
            this.hight = hight;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root==null){
            return false;
        }
//        int depth = 1;
        Queue<TH> queue = new LinkedList<TH>();
        queue.offer(new TH(root,root.val));
        while (!queue.isEmpty()){
            TH node = queue.poll();
            if (node.root.left == null && node.root.right == null && node.hight == targetSum) {
                return true;
            }else {
//                depth++;
                if (node.root.left != null) {
                    queue.offer(new TH(node.root.left,node.hight+node.root.left.val));
                }
                if (node.root.right != null) {
                    queue.offer(new TH(node.root.right,node.hight+node.root.right.val));
                }

            }
        }
        return false;
    }
}