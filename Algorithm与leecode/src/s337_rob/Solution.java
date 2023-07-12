package s337_rob;

import org.junit.Test;

import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;this.left = left;
        this.right = right;
    }
}
public class Solution {
    @Test
    public void test(){
        rob(new TreeNode(3,new TreeNode(2,null,new TreeNode(3)),new TreeNode(3,null,new TreeNode(1))));
    }
    public int rob(TreeNode root) {
        int[] result = result(root);
        return Math.max(result[0],result[1]);
    }
    public int[] result(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }
        int[] result1 = result(root.left);
        int[] result2 = result(root.right);
        int[] result = new int[2]; //0打劫  1不打劫
        result[0] =  result1[1]+result2[1]+root.val; //打劫
        result[1] = Math.max(result1[1],result1[0])+Math.max(result2[1],result2[0]);   //不打劫
        return result;
    }
}
