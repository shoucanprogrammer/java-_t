package s658_findClosestElements;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        findClosestElements(new int[]{1,3},1,2);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < k; i++){
            list.add(arr[i]) ;
            sum += Math.abs(arr[i] - x );
        }
        for (int l = 1;  l < arr.length-k+1; l++){
            int lastSum = sum;
            sum = sum - Math.abs(arr[l-1]-x);
            sum = sum + Math.abs(arr[l+k-1]-x);
            if (sum == lastSum && arr[l-1] == arr[l+k-1]){
                list.remove(0);
                list.add(arr[l+k-1]);
            }else if (sum<lastSum){
                list.remove(0);
                list.add(arr[l+k-1]);
            }else {
                break;
            }
        }
        return list;
    }
}
