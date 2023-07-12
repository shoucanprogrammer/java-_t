package s101_isSymmetric;
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
    public boolean isSymmetric(TreeNode root) {
        if (root.left!=null&&root.right!=null){
            boolean sameTree = isSameTree(root.left, root.right);
            return sameTree;
        }else if (root==null){
            return true;
        }else if (root.left==null&&root.right==null){
            return true;
        }
            return false;

    }
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean inorder = inorder(p, q);
        return inorder;
    }
    public boolean inorder(TreeNode root, TreeNode root1) {
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
            inorder(root.left,root1.right);
        }
        if (flag==true){
            inorder(root.right,root1.left);
        }
        return flag;
    }
}
