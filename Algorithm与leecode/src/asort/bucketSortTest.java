package asort;

import java.util.Arrays;

public class bucketSortTest {
    public static void bucketSort(int[] num) {

        // 遍历原始数组，找到数组中的最大值
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }

        // 创建一个下标为原始数组中最大值的桶数组,该桶数组的下标代表元素，该数组下标所对应的值代表这个值出现的次数

        int[] bucketArray = new int[max + 1];

        // 再次遍历原始数组，得到原数组中存在的各个元素，以及出现的次数
        for (int i = 0; i < num.length; i++) {
            bucketArray[num[i]]++;
        }

        // 遍历桶数组,外层循环从桶的第一位开始（即下表为零）；内层循环遍历桶数组中下标为i的值出现的次数
        int index = 0;
        for (int i = 0; i < bucketArray.length; i++) {
            for (int j = 0; j < bucketArray[i]; j++) {
                num[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] num=new int[] { 2,5,6,8,5,2,9,6};
        bucketSort(num);
        System.out.println(Arrays.toString(num));

    }
}

