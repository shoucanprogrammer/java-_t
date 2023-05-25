package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int []arr = {101,34,119,1};
        int[] arr = new int[80000];
        for(int i=0;i<80000;i++){
            arr[i] = (int) (Math.random()*8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println(data1Str);
        insertSort(arr);
        Date data2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String data2Str = simpleDateFormat2.format(data2);
        System.out.println(data2Str);

    }

    public static void insertSort(int[] arr){

        //使用for循环简化代码
          for (int i = 1; i <arr.length;i++){
              //使用逐步推导的方式来讲解，遍历理解
              //第1轮{101，34，119，1}; =>{334,101,119,1}
              //定义待插值
              int insertVal = arr[i];
              int insertIndex = i-1;//即arr[1]的前面这个的下标
              //给insertVal 找到插入的位置
              //说明
              //1.insertIndex >=0 保证在给insertVal 找插入位置，不越界
              //2 insertVal<arr[insertIndex]待插入的数，还没找到值当的位置
              //3 需要将insertIndex 后移
              while (insertIndex >=0 && insertVal<arr[insertIndex]){
                  arr[insertIndex+1] = arr[insertIndex];
                  insertIndex--;
              }
              //当退出循环时，说明插入的位置找到，insertIndex+1
              arr[insertIndex+1] = insertVal;
//              System.out.printf("%d epoch:%s\n",i, Arrays.toString(arr));


          }


    }

}







