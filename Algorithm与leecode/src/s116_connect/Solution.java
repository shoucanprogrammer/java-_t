package s116_connect;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {
    @Test
    public void test(){
        connect(new Node(1,new Node(2),new Node(3),null));
    }
    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0; i< size;i++){
                Node node = queue.poll();
                if (i < size -1){
                    node.next = queue.peek();
                }
                //填充
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }


        }
        return root;
    }
}
