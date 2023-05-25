package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排序
        int arr[] = {4,6,8,5,9};
        heapSort(arr);
//        adjustHeap(arr,1, arr.length);
//        System.out.println("first:" + Arrays.toString(arr));
//        adjustHeap(arr,0, arr.length);
//        System.out.println("second:" + Arrays.toString(arr));
    }
    //编写一个堆排序的方法
    public static void heapSort(int arr[]){
        int temp = 0;
       //完成最终代码
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        //当for循环结束后，我们已经将以i为父结点的树的最大值，放在了最顶端（局部）
        for (int i = arr.length/2 -1; i>=0;i--){
            adjustHeap(arr,i, arr.length);
        }
        /*
        2将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        3重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，
        反复执行调整＋交换步骤，直到整个序列有序
         */
        for (int j = arr.length-1;j>0;j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort1(int arr[]){
        int temp = 0;

        for (int i = arr.length/2 -1; i>=0;i--){
            adjustHeap(arr,i, arr.length);
        }
        /*
        2将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        3重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，
        反复执行调整＋交换步骤，直到整个序列有序
         */
        for (int j = arr.length-1;j>0;j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap1(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }



    //将一个数组，调整成一个大顶堆
    /*
    功能举例 int arr[] = {4,6,8,5,9}; => i =1 =>adjustHeap =>得到{4,9,8,5,6}
    如果我们再次调用adjustHeap传入的是i=0=>{4,9,8,5,6} =>{9,6,8,5,4}
    arr 待调整的数组
    i 表示非叶子结点在数组中索引
    length表示多少个元素继续调整，length实在逐渐减少
     */
    public static void adjustHeap(int arr[], int i,int length){
         int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //说明1.k = i*2+1是i结点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if (k + 1 <length && arr[k]<arr[k+1]){//说明左子节点的值小于右子结点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp){
                //如果子结点大于父结点
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父结点的树的最大值，放在了最顶端（局部）
        arr[i] = temp;
    }


    public static void adjustHeap1(int arr[], int i,int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //说明1.k = i*2+1是i结点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
