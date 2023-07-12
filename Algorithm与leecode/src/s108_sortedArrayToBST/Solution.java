package s108_sortedArrayToBST;

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
        sortedArrayToBST(new int[]{1,2,3,4,5,6});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null){
            return null;
        }
        TreeNode root = inorderBuild(0, nums.length - 1, nums);
        return root;
    }

    public TreeNode inorderBuild(int left,int right,int[] nums){
        if (right<left){
            return null;
        }

        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorderBuild(left,mid-1,nums);
        root.right = inorderBuild(mid+1,right,nums);
        return root;
    }
}
