package tree.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinartSortTree binartSortTree = new BinartSortTree();
        //循环的添加结点到二叉树
        for (int i = 0; i < arr.length; i++){
            binartSortTree.add(new Node(arr[i]));
        }
        //中序遍历二叉树
        System.out.println("infixOrdeer");
        binartSortTree.infixOrdeer();//1，3，5，7，9，10，12
    }
}
//创建二叉排序树
class BinartSortTree{
    private Node root;
    //添加结点的方法
    public void add(Node node){
        if (root == null){
            root = node;//如果root为空则直接让root指向node
        }else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrdeer(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }

}
//创建Node结点
class Node{
    int value;
    Node left;
    Node right;

    //查找要删除的结点
    public Node search(int value){
        if (value == this.value){//找到就是该结点
            return this;
        } else if (value < this.value){//如果查找的值小于当前结点，向左子树递归查找
            if (this.left == null){
                 return null;
            }
            return this.left.search(value);
        }else { //如果查找的值不小于当前结点，向右子树递归查找
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除结点的父结点

    /**
     *
     * @param value 要找到的结点的值
     * @return      返回要删除结点的父结点 如果没有返回null
     */
    public Node searchParent(int value){
        //如果当前的结点就是要删除的结点的父节点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);//向左子树递归查找
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value); //向右子树递归查找
            }else {
                return null;//没有父节点
            }
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加结点
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if (node == null){
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.value < this.value){
            //如果当前结点左子树为null
            if (this.left == null){
                this.left = node;
            }else {
                //递归的向左子树添加
                this.left.add(node);
            }
        }else {//添加的结点的值大于当前结点的值
            if (this.right == null){
                this.right = node;
            }else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }


}
