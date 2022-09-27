package s7_reverse;



import org.junit.Test;

import java.util.LinkedList;

public class Solution {
    @Test
    public void test2(){
        int reverse = reverse2(1147483649);
        System.out.println();
    }
    public int reverse(int x){
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        int x1;
        long x2 = 0;
        //-231 <= x <= 231 - 1

        while (true){
            x1 = x % 10;
            list.add(x1);
            x = x/10;
            count++;
            if (-1 < x && x < 1){
                break;
            }
        }
        x = 0;
        for (int i = 0; i < count;i++ ){
            x2 += list.removeLast()*Math.pow(10,i);
            if (Math.pow(-2,31)>x2 || x2>(Math.pow(2,31)-1))
                return 0;
        }
        return (int) x2;

    }
    public int reverse2(int x){

        int count = 0;
        int x1;
        int x2 = 0;
        int x3;
        while (true){
            x1 = x % 10;
            x3 = x2;
            x2 = x2*10+x1;
            if (x2/10 != x3){
                return 0;
            }
            x = x/10;
            count++;
            if (-1 < x && x < 1){
                break;
            }
        }
        return x2;
    }

}
