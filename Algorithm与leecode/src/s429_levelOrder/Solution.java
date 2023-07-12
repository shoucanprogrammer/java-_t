package s429_levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            ans.add(list);
        }
    return ans;
    }
}
