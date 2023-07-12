package asort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {99, 55, 2, 3, 9, 10, 22, 34, 67, 89, 69, 92, 101, 102};
        //增量
        int gap = arr.length;
        //排序
        sort(arr, gap);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr, int gap) {
        //确定新一轮分组的增量
        gap = gap / 2;
        //对数组进行分组
        for (int i = 0; i < gap; i++) {
            for (int j = i + gap; j < arr.length; j += gap) {
                //获取当前元素，然后在本组内部向前比较并排序
                int current = arr[j];
                for (int k = j - gap; k >= i; k -= gap) {
                    if (arr[k] > current) {
                        //插入
                        arr[k + gap] = arr[k];
                        arr[k] = current;
                    }
                }
            }
        }

        if (gap > 1) {
            sort(arr, gap);
        }
    }
}