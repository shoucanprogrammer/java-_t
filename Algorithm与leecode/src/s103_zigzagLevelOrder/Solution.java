package s103_zigzagLevelOrder;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        middle_order(root,1);
        return list;
    }
    public void middle_order(TreeNode root, int h){
        if (root==null){
            return;
        }

        if (h>list.size()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            list.add(arrayList);
        }else {
            List<Integer> list1 = list.get(h-1);
            if (h%2==0){
                list1.add(root.val);
            }else {
                list1.add(0,root.val);
            }

        }
        middle_order(root.right,h+1);
        middle_order(root.left,h+1);
    }
}
