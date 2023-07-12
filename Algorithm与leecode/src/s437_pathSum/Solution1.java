package s437_pathSum;

import org.junit.Test;

import java.util.HashMap;

public class Solution1 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        pathSum(root,1);
    }
    public int pathSum(TreeNode root, int targetSum){
        if (root == null){
            return 0;
        }
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        int ans = preSearch(root, targetSum, map, 0);
        return ans;
    }

    public int preSearch(TreeNode root,int targetSum,HashMap<Long,Integer> map,long curr){
        if (root == null){
            return 0;
        }
        int ret = map.getOrDefault(curr + root.val-targetSum,0);
        map.put(curr+ root.val,map.getOrDefault(curr+root.val,0)+1);
        ret += preSearch(root.left,targetSum,map,curr+ root.val);
        ret += preSearch(root.right,targetSum,map,curr+ root.val);
//        map.put(curr+ root.val,map.get(curr+root.val)-1);
        map.put(curr+ root.val, map.getOrDefault(curr+ root.val, 0) - 1);
        return ret;
    }
}
