package Offer34_pathSum;

import org.junit.Test;

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
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res.add(root.val);
        dfs(root,target,0);
        return ans;
    }
    public void dfs(TreeNode root, int target,int sum){
        sum += root.val;
        if (root.left == null && root.right == null){
            if (sum == target){
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        if (root.left != null){
            res.add(root.left.val);
            dfs(root.left,target,sum);
            res.remove(res.size()-1);
        }
        if (root.right!= null){
            res.add(root.right.val);
            dfs(root.right,target,sum);
            res.remove(res.size()-1);
        }
    }
}
