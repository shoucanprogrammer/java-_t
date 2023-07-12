package s111_minDepth;

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

    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
//        int depth = 1;
        Queue<TH> queue = new LinkedList<TH>();
        queue.offer(new TH(root,1));
        while (!queue.isEmpty()){
           TH node = queue.poll();
            if (node.root.left == null && node.root.right == null) {
                return node.hight;
            }else {
//                depth++;
                if (node.root.left != null) {
                    queue.offer(new TH(node.root.left,node.hight+1));
                    }
                if (node.root.right != null) {
                    queue.offer(new TH(node.root.right,node.hight+1));
                    }

                }
        }
        return 0;
    }
}
