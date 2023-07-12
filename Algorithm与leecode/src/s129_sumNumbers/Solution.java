package s129_sumNumbers;

import org.junit.Test;

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
        sum(new TreeNode(1,new TreeNode(2),null));
    }
    private int ans = 0;
    private StringBuilder  builder = new StringBuilder();
    public int sumNumbers(TreeNode root) {
        sum(root);
        return ans;
    }
    public void  sum(TreeNode root){
        if (root.left == null && root.right == null){ //叶子节点
            //求和
            builder.append(root.val);
            ans += Integer.valueOf(builder.toString());
            builder.deleteCharAt(builder.length()-1);
            return;
        }
        builder.append(root.val);
        if (root.left != null)
            sum(root.left);
        if (root.right!= null)
            sum(root.right);
        builder.deleteCharAt(builder.length()-1);
    }

}
