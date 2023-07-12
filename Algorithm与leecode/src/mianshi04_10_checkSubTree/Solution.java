package mianshi04_10_checkSubTree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //深度遍历
        boolean check = check(t1, t2);
        if (t1 != null){
            boolean left = checkSubTree(t1.left, t2);
            boolean right = checkSubTree(t1.right, t2);
            return check || left || right;
        }
        if (t1 == null && t2 == null){
            return true;
        }
        return false;
    }
    public boolean check(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        //一个为null 一个不为null
        if ((t1 == null && t2 != null ) || (t2 == null && t1 != null )){
            return false;
        }
        if (t1.val == t2.val){
            //遍历
            boolean left = check(t1.left, t2.left);
            boolean right = check(t1.right, t2.right);
            return left && right;
        }else {
            return false;
        }

    }
}
