package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];
        mergeSort(arr,0, arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[80000000];
//        for(int i=0;i<80000000;i++){
//            arr[i] = (int) (Math.random()*800000000);
//        }
//        int temp[] = new int[arr.length];
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
//        String data1Str = simpleDateFormat.format(data1);
//        System.out.println(data1Str);
//        mergeSort(arr,0, arr.length-1,temp);
//        Date data2 = new Date();
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
//        String data2Str = simpleDateFormat2.format(data2);
//        System.out.println(data2Str);

    }
    //分+合方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left + right)/2;//中间索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //想右递归进行分解
            mergeSort(arr, mid +1, right, temp);
            //到合并
            merge(arr,left,mid,right,temp);


        }
    }


    //合并的方法
    /*
    arr 排序的原始数组
    left 左边有序序列的初始的初索引
    中间索引
    右边索引
    做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){

        int i = left;//初始化i，左边也有序列的初始索引
        int j = mid + 1;//初始化j,右边有序列的初始索引
        int t = 0;//指向temp数组的当前索引
        //（一）
        //先把左右两边()的数据按规则填充到temp数组
        //直到左右两边的有序序列，又一遍处理完毕为止
        while (i<= mid && j<=right){//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列到当前元素
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1 ;
            }else {//反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }

        }
        //（二）
        //把所有剩余数据的一边的数据依次全部填充到temp
        while (i<= mid){//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t]  = arr[i];
            t += 1;
            i += 1;
        }
        while (j<= right){//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t]  = arr[j];
            t += 1;
            j += 1;
        }

        //（三）
        //将temp数组的元素拷贝到arr.
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft +=  1;
        }
    }
}
