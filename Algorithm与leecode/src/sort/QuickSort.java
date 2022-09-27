package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70,-1,900,4561};
        int[] arr = new int[800000000];
        for(int i=0;i<800000000;i++){
            arr[i] = (int) (Math.random()*800000000);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println(data1Str);
        quickSort(arr,0,arr.length-1);
        Date data2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data2Str = simpleDateFormat2.format(data2);
        System.out.println(data2Str);
//        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;//左下标
        int r = right;//右下标
        int temp = 0;
        //中轴
        int pivot = arr[(left+right)/2];
        //while循环的目的是让比pivott值小放到左边
        //比pivot值大的放右边
        while (l<r){//
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot){
                r -= 1;
            }
            //说明pivot的左右两边的值，已经按照左右边全部是
            if (l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l] == pivot值 相同--，前移
            if (arr[l] == pivot){
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值相等++，后移
            if (arr[r] == pivot){
                l += 1;
            }
        }


        if (l == r){
            l += 1;
            r -=1;
        }
        if (left<r){
            quickSort(arr,left,r);
        }
        if (right>l){
            quickSort(arr,l,right);
        }
    }

}
