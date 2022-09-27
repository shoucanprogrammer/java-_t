package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ShellSort {
    public static void main(String[] args) {
//        int [] arr = {8,9,1,7,2,3,5,4,6,0};
        //使用逐步推到的方式来编写希尔排序
        int[] arr = new int[800000000];
        for(int i=0;i<800000000;i++){
            arr[i] = (int) (Math.random()*800000000);
        }
        //希尔排序的第1轮排序
        //因为第一轮排序，是将10个数据分成了5组
        System.out.println("Before sort");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println(data1Str);
        shellSort2(arr);
        System.out.println("After sort");
        Date data2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data2Str = simpleDateFormat2.format(data2);
        System.out.println(data2Str);

    }

    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap > 0; gap/=2){
            for (int i = gap;i < arr.length; i++){
                for (int j = i - gap; j >= 0; j -= 5){
                    //如果当前元素大于
                    if (arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
//            System.out.println("shell:" + Arrays.toString(arr));
        }
    }
    //移位法
    public static void shellSort2(int[] arr){
        //

        for (int gap = arr.length/2; gap > 0; gap/=2){
             for (int i = gap; i<arr.length;i++){
                 int j = i;
                 int temp = arr[j];
                 if (arr[j]<arr[j-gap]){
                     while (j-gap>=0&&temp<arr[j-gap]){
                         //移动
                         arr[j] = arr[j-gap];
                         j -= gap;
                     }
                     //退出while后，就给temp找到插入的位置
                      arr[j] = temp;
                 }
             }
        }
    }

}
