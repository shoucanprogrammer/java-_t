package s202_isHappy;

import org.junit.Test;

import java.util.HashSet;

public class Solution {
    @Test
    public void test(){
        isHappy(2);
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1){
            set.add(n);
            int sum = 0;
            while (n > 0){
                int a = n % 10;
                sum += (int) Math.pow(a,2);
                n = n/10;
            }
            if (set.contains(sum)){
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
