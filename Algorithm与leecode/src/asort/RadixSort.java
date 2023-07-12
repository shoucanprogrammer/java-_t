package asort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
//        radixSort(arr);
////        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000000];
        for(int i=0;i<80000000;i++){
            arr[i] = (int) (Math.random()*80000000);
        }
        //希尔排序的第1轮排序
        //因为第一轮排序，是将10个数据分成了5组
        System.out.println("Before sort");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println(data1Str);
        radixSort(arr);
        System.out.println("After sort");
        Date data2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data2Str = simpleDateFormat2.format(data2);
        System.out.println(data2Str);
    }

    public static void radixSort(int[] arr){
        //得到数组中最大数的位数
        int max = arr[0];
        for (int i =1; i <arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

         //第一轮排序（针对每个元素的个位进行排序）
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //为了防止再放入数的时候，数据溢出、
        //基数排序 空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //记录桶中实际存放元素个数，定义一维数组来记录
        //
        int[] bucketElementCounts = new int[10];

        //这里使用循环
        for(int i = 0, n =1 ; i < maxLength; i++,n *= 10){
            //第i轮（针对每个元素的个位进行排序处理）
            for (int j = 0; j < arr.length; j++){
                //取出每行元素的n位
                int digitOfElement = arr[j]/(n)%10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标一次取出数据，放到原来数组）
            int index = 0;
            for (int k= 0; k < bucketElementCounts.length; k++){
                //如果桶中有数据，我们才放到原来数组
                if (bucketElementCounts[k] != 0){
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for (int l = 0; l<bucketElementCounts[k];l++){
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
//            System.out.println(Arrays.toString(arr));

        }

//
//        for (int j = 0; j < arr.length; j++){
//            //取出每行元素的个位
//            int digitOfElement = arr[j]%10;
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标一次取出数据，放到原来数组）
//        int index = 0;
//        for (int k= 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据，我们才放到原来数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶即第k个桶（即第k个一维数组），放入
//                for (int l = 0; l<bucketElementCounts[k];l++){
//                    //取出元素放入到arr
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            //第一轮处理后需要将每个bucketElementCounts[k] = 0
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        for (int j = 0; j < arr.length; j++){
//            //取出每行元素的十位
//            int digitOfElement = arr[j] / 10 % 10;
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标一次取出数据，放到原来数组）
//        index = 0;
//        for (int k= 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据，我们才放到原来数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶即第k个桶（即第k个一维数组），放入
//                for (int l = 0; l<bucketElementCounts[k];l++){
//                    //取出元素放入到arr
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        //第二轮
//        for (int j = 0; j < arr.length; j++){
//            //取出每行元素的十位
//            int digitOfElement = arr[j] / 100 % 10;
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照这个桶的顺序（一维数组的下标一次取出数据，放到原来数组）
//        index = 0;
//        for (int k= 0; k < bucketElementCounts.length; k++){
//            //如果桶中有数据，我们才放到原来数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶即第k个桶（即第k个一维数组），放入
//                for (int l = 0; l<bucketElementCounts[k];l++){
//                    //取出元素放入到arr
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
