package s559_maxDepth;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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
    public int maxDepth(Node root){
        if (root == null){
            return 0;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        int ans = 0;
        while (!stack.isEmpty()){
            int size = stack.size();
            for (int i = 0; i < size; i++){
                Node node = stack.pop();
                List<Node> children = node.children;
                for (Node child : children){
                    stack.push(child);
                }
            }
            ans++;
        }
    return ans;
    }
}
