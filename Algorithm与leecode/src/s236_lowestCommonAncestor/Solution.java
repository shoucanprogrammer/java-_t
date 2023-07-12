package s236_lowestCommonAncestor;

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

    private List<TreeNode> pList = new ArrayList<>();
    private List<TreeNode> qList = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preSearch(root,p,pList);
        preSearch(root,q,qList);
        TreeNode treeNode = null;
        int i = 0;
        while ( i < pList.size()  && i < qList.size() && pList.get(i) == qList.get(i)){
            treeNode = pList.get(i);
           i++;
        }
        return treeNode;
    }
    public boolean preSearch(TreeNode root,TreeNode target,List<TreeNode> list){
        if (root == null ){
            return  false;
        }
        if ( root == target){
            list.add(root);
            return true;
        }
        list.add(root);
        boolean a = preSearch(root.left, target, list);
        boolean b = preSearch(root.right, target, list);
        if (a||b){
            return true;
        }else {
            list.remove(list.size()-1);
            return false;
        }


    }
}
