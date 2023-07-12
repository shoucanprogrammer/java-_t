package s235_lowstCommonAncestor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    @Test
    public void test(){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left =  node2;
        node1.right = node3;
        lowestCommonAncestor(node1,node2,node3);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, new ArrayList<TreeNode>(), p.val);
        List<TreeNode> pathQ= getPath(root, new ArrayList<TreeNode>(), q.val);
        int sizeP = pathP.size();
        int sizeQ = pathQ.size();
        int i = 0;
        TreeNode ans =  new TreeNode(0);
        while (i < sizeP && i < sizeQ &&pathP.get(i) == pathQ.get(i)){
            ans = pathP.get(i);
            i++;
        }
        return ans;
    }
    public List<TreeNode> getPath(TreeNode root , List<TreeNode> list,int target){
            list.add(root);
            if (root == null){
                return list;
            }
            if (root.val == target){
                return list;
            }
            if (root.val > target){
                List<TreeNode> path = getPath(root.left, list, target);
                return path;
            }
            if (root.val < target){
                List<TreeNode> path = getPath(root.right, list, target);
                return path;
            }
            return null;
    }
}
