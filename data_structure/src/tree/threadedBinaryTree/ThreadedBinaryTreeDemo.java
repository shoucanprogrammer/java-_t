package tree.threadedBinaryTree;

import java.io.RandomAccessFile;
import java.util.TreeMap;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args){
        //test
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        //二叉树，后面我们要递归创建，现在简单使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //test
        HeroNode leftNode = node5.getLeft();
        System.out.println(leftNode);
        HeroNode rightNode = node5.getRight();
        System.out.println(rightNode);

//        //当线索化二叉树，不能使用原来遍历方式
        System.out.println("使用线索化的遍历方式");
        threadedBinaryTree.threadList();
    }
}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    public HeroNode right;
    //说明
    //规定1.如果leftTpe == 0 表示指向的时左子树，如果为1则表示指向前驱结点Z
    //2 如果rightType==0 表示指向是右子树，如果是1表示指向后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

//定义ThreadedBinaryTree实现了线索化功能的二叉树
class ThreadedBinaryTree{
    private HeroNode root;
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre总是保留前一个结点
    private HeroNode pre = null;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    //遍历线索化二叉树的方法
     public void threadList(){
        //定义一个变量，存储当前遍历的结点，从root开始
         HeroNode node = root;
         while (node != null){
             //循环的找到leftType == 1的结点，第一个找到就是8结点
             //后面随着遍历而变化，因为当leftType==1时，说明该结点是按照线索化
             //处理后的有效结点
             while (node.getLeftType() == 0){
                 node = node.getLeft();
             }
             //打印当前这个结点、
             System.out.println(node);
             //如果当前结点的右指针指向的是后继结点，就一直输出
             while (node.getRightType() == 1){
                //获取到当前结点的后继结点
                 node = node.getRight();
                 System.out.println(node);
             }
             //替换这个遍历的结点
             node = node.getRight();
         }
     }


    //重载一把threadNodes
    public void threadedNodes(){
        this.threadedNodes(root);
    }
    //
    public void threadedNodes(HeroNode node){
        //如果node==null 不能线索化、
        if (node == null){
            return;
        }
         //1先线索化左子树
        threadedNodes(node.getLeft());
        //2线索化当前结点
        //处理当前结点的前驱结点
        //以8结点的left指向null，8节点的.leftType = 1；
        if (node.getLeft() == null){
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }
        //处理后继结点
        if(pre != null && pre.getRight() == null){
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //没处理一个结点后，让当前结点是下一个系欸但的额前驱结点
        pre = node;
        //3线索化右子树
        threadedNodes(node.getRight());
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