package s404_sumOfLeftLeaves;

import org.junit.Test;

import java.util.*;

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
        sumOfLeftLeaves(new TreeNode(1,new TreeNode(2),new TreeNode(3)));
    }
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
       dfs(false,root);
       return ans;
    }
    public void dfs(boolean fla , TreeNode treeNode){
        if (fla == true && treeNode.right == null && treeNode.left == null){
            ans += treeNode.val;  //找到左子树
        }
        if (treeNode.left != null){
            dfs(true,treeNode.left);
        }
        if (treeNode.right != null){
            dfs(false,treeNode.right);
        }
    }
}
