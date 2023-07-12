package s654_constructMaximumBinaryTree;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        TreeNode root = null;
        for (int i = 0; i < n; ++i) {
            if (left[i] == -1 && right[i] == -1) {
                root = tree[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                tree[left[i]].right = tree[i];
            } else {
                tree[right[i]].left = tree[i];
            }
        }
        return root;
    }


}
