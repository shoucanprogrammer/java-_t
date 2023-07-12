package s437_pathSum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        pathSum(root,1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        int dfs = dfs(root, prefix, 0, targetSum);
        return dfs;
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
