package tree;

import java.util.stream.Stream;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1,"songjiang");
        HeroNode node2 = new HeroNode(2,"wuyong");
        HeroNode node3 = new HeroNode(3,"lujunyi");
        HeroNode node4 = new HeroNode(4,"linchong");
        HeroNode node5 = new HeroNode(5,"guansheng");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);
//        System.out.println("preOrder");
//        binaryTree.preOrder();
//        System.out.println();
//        System.out.println("infixOrder");
//        binaryTree.infixOrder();
//        System.out.println();
//        System.out.println("postOrder");
//        binaryTree.postOrder();
//        System.out.println();
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("find no = %d, name = %s ",resNode.getNo(),resNode.getName());
//        }else {
//            System.out.printf("no find no = %d",5);
//        }
        //测试删除结点
        System.out.println("befor del");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("befor del");
        binaryTree.preOrder();
    }
}
//定义BinartTree二叉树
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }
    //删除结点
    public void delNode(int no){
        if (root != null){
            //如果只有一个root结点，这里立即判断root是不是要删除结点
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("empty");
        }
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("empty");
        }
    }
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("empty");
        }
    }
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("empty");
        }
    }
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}


//先创建节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    public HeroNode right;
    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除结点
    public void delNode(int no){
       if (this.left != null && this.left.no == no){
           this.left = null;
           return;
       }
       if (this.right != null && this.right.no == no){
           this.right = null;
           return;
       }
       if (this.left != null){
           this.left.delNode(no);
       }
       if (this.right != null){
           this.right.delNode(no);
       }
    }



    //编写前序遍历的方法
    //中序遍历的方法
    //后序遍历的方法
    public void preOrder(){
        System.out.print(this);
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.print(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后续遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.print(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        //判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
        HeroNode resNode = null;//flag
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){//左子树找到
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    public HeroNode infixOrderSearch(int no){
        //判断当前结点的左子结点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        return resNode;

    }



}