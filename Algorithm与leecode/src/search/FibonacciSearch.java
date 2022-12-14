package search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int [] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,1));
    }
    //因为后面我们mid = low + F(K-1)-1,需要使用到斐波那契数列，因此我们需先获取斐波那契数列
    //非递归
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i =2; i < maxSize; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找法

    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数组的下标
        int mid = 0;//存放mid值
        int f[] = fib();//获取到斐波那契数列
        //获取斐波那契数列数列下标
        while (high > f[k] - 1){
            k++;
        }
        //因为f[k]值可能大于长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp  = Arrays.copyOf(a,f[k]);
        //实际上需要使用a数组最后的数填充 temp
        for (int i = high +1; i < temp.length; i++){
            temp[i] = a[high];
        }
        //使用while来循环处理，找到我们的数key
        while (low <= high){
            mid = low + f[k-1]-1;
            if (key < temp[mid]){//我们应该继续向数组的前面查找（左边）
                high = mid - 1;
                //在f[k-1]的前面继续查找k--
                //即下次循环mid = f[k-1-1]-1
                k-- ;
            }else if (key > temp[mid]){//我们应该继续向数组的后面查找
                low = mid + 1;
                //为什么是 k -=2；
                //说明
                //全部元素 = 前面的元素 + 后边的元素
                // f[k] = f[k-1] + f[k-2]
                //3因为后面我们有f[k-2]所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                //即在f[k-2]的前面进行查找 k -=2
                //即下次循环mid = f[k-1-2] -1
                k -= 2;
            }else {//找到
                if (mid <= high){
                    return mid;
                }
                else {
                    return high;
                }

            }
        }
        return -1;
    }

}
