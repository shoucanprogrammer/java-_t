package tree;

import java.lang.ref.PhantomReference;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOder(0);
    }

}

//编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOder(int index){
        //如果数组为空
        if (arr == null||arr.length==0){
            System.out.println("arr is empty");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1)<arr.length){
            preOder(2 * index + 1);
        }
        //向右递归
        if ((index * 2 + 2)<arr.length){
            preOder(2 * index + 2);
        }
    }
}
