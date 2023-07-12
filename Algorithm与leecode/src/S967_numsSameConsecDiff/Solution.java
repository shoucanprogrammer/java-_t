package S967_numsSameConsecDiff;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        numsSameConsecDiff(2,1);
    }
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = (int) Math.pow(10,n-1); i < Math.pow(10,n);i++){
            String s = String.valueOf(i);
            boolean fla = true;
            for (int j = 0; j < n-1; j++){
                if (k == Math.abs(s.charAt(j)-s.charAt(j+1))){
                }else {
                    fla = false;
                    break;
                }
            }
            if (fla){
                list.add(i);
            }
        }
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
    return  ans;
    }
}
