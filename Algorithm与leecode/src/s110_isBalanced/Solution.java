package s110_isBalanced;
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
    private boolean fla = true;
    public boolean isBalanced(TreeNode root) {
       if (root==null){
           return true;
       }
         isBalanced(root, 0);
       return fla;
    }

    public int isBalanced(TreeNode root,int h) {
        if (root==null){
            return 0;
        }
        int left_h = isBalanced(root.left,h);
        int right_h = isBalanced(root.right,h);
        if (left_h-right_h>1||left_h-right_h<-1){
            //失败
            fla = false;
        }
        h = Math.max(left_h,right_h);
        h++;
        return h;
    }



    public boolean isBalanced1(TreeNode root) {
        if (root==null){
            return true;
        }
        int left_h = isBalanced2(root.left);
        int right_h = isBalanced2(root.right);
        if (left_h-right_h>1||left_h-right_h<-1){
            //失败
            return false;
        }else {
            return true;
        }

    }

    public int isBalanced2(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left_h = isBalanced2(root.left);
        int right_h = isBalanced2(root.right);

        return Math.max(left_h,right_h)+1;
    }
}
