package s357_countNumbersWithUniqueDigits;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    @Test
    public void test(){
        countNumbersWithUniqueDigits(0);
    }
    public int countNumbersWithUniqueDigits(int n) {
        int max = 1;
      while (n > 0){
          max = max * 10;
          n--;
      }
      int sum = 0;
      for (int i = 0; i < max; i ++){
          Set<Integer> set = new HashSet<>();
          int cur = i;
          boolean fla = true;
          while (cur > 0){
              int a = cur % 10;
              if (set.contains(a)){
                  fla = false;
                  break;
              }else {
                  set.add(a);
              }
              cur = cur / 10;
          }
          if (fla){
              sum ++;
          }

      }

      return sum;
    }
}
