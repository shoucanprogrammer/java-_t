package s100_isSameTree;

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
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean inorder = inorder(p, q);
        return inorder;
    }
    public boolean inorder(TreeNode root,TreeNode root1) {
        if (root == null&&root1==null) {
            return true;
        }else if (root==null&&root1!=null){
            flag = false;
            return false;
        }else if (root1==null&&root!=null){
            flag = false;
            return false;
        }
        if (root.val!=root1.val){
            flag =  false;
        }
        if (flag==true){
            inorder(root.left,root1.left);
        }
        if (flag==true){
            inorder(root.right,root1.right);
        }
        return flag;
    }
}
