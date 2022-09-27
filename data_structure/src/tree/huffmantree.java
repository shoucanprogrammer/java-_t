package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class huffmantree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};

        preOrder(createHuffmanTree(arr));
    }
    //创建哈夫曼树的方法
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("empty");
        }
    }
    //创建哈夫曼树
    public static Node createHuffmanTree(int[] arr){
        //第一步为了操作方便
        //遍历arr数组
        //将arr的每个元素构成一个Node
        //将Node放入ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr){
            nodes.add(new Node(value));
        }
        while (nodes.size()>1){
            //排序从小到大
            Collections.sort(nodes);
            System.out.println("nodes="+nodes);
            //取出根节点全职最小的两颗二叉树
            //(1)取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //(2)取出权值第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            //构建新的一颗二叉树
            Node parent = new Node(leftNode.value+rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }
}
//创建结点
//为了让Node对象持续排序Collections集合排序
//让node 实现Comparable接口
class Node implements Comparable<Node>{
    int value;//结点权值
    Node left;//指向左子树
    Node right;//指向右子树
    public Node(int value){
        this.value = value;
    }
    //写一个前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value - o.value;
    }
}