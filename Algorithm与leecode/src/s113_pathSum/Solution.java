package s113_pathSum;

import java.util.ArrayList;
import java.util.List;
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
    private List<List<Integer>> pathSum = new ArrayList<List<Integer>>();
    private List<Integer> onePath = new ArrayList<Integer>();
    private int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrder(root,targetSum);
        return pathSum;
    }

    public void preOrder(TreeNode root,int targetSum){
        if (root == null){
            return;
        }
        targetSum = targetSum - root.val;
        onePath.add(root.val);
        if (root.left == null && root.right == null &&sum == targetSum){

            pathSum.add(new ArrayList<>(onePath));
        }
        preOrder(root.left,targetSum);
        preOrder(root.right,targetSum);
        onePath.remove(onePath.size()-1);
    }
}
