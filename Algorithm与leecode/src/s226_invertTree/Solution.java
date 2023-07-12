package s226_invertTree;

import org.junit.Test;

import java.util.ArrayDeque;

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
        invertTree(new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7)));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return root;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode node = deque.poll();
                TreeNode cur = node.left;
                node.left = node.right;
                node.right = cur;
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
    return root;
    }
}
