package s102_levelOrder;


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

    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        middle_order(root,1);
        return list;
    }
    public void middle_order(TreeNode root,int h){
        if (root==null){
            return;
        }
        h++;
        if (h>list.size()){
            ArrayList<Integer> arrayList = new ArrayList<>(root.val);
            list.add(arrayList);
        }else {
            List<Integer> list1 = list.get(h-1);
            list1.add(root.val);
        }
        middle_order(root.left,h);
        middle_order(root.right,h);

    }
}
