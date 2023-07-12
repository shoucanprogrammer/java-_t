package asort;

import javax.management.Query;

public class myQuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int midValue = arr[(l+r)/2];
        int mid  = (l+r)/2;
        while (l < r){
            while (arr[l] < midValue) {
                l++;
            }
            while (arr[r] > midValue) {
                r--;
            }
            if (l >= r){
                break;
            }
            //交换
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            if (arr[r] == midValue){
                l++;
            }   //为了打破循环
            if (arr[l] == midValue){
                r -= 1;
            }
        }
        if (l == r){
            l += 1;
            r -=1;
        }
        if (left<r)
            quickSort(arr,left,r);
        if (right>l)
            quickSort(arr,l,right);
        return arr;
    }
}
