package s69_mySqrt;

import org.junit.Test;

//public class mySqrt {
//    @Test
//    public void test(){
//        mySqrt(2147395599);
//    }
//    public int mySqrt(int x){
//        if (x==1){
//            return x;
//        }
//        int i = mySqrtfin(0, x, x);
//        return i;
//    }
//    public int mySqrtfin(int a ,int b , int x){
//        if (b-a == 1){
//            return a;
//        }
//        int mid = (a+b)/2;
//        if (mid*mid > x){
//            b = mid;
//        }else if (mid==x){
//            return mid;
//        }else {
//            a = mid;
//        }
//        return mySqrtfin(a,b,x);
//    }
//
//}
public class mySqrt {
    @Test
    public void test(){
        int i = mySqrt(8);
        System.out.println(i);
    }
    public int mySqrt(int x){
        if (x==1){
            return x;
        }
        int a = 0;
        int b = x;
        if (b-a == 1){
            return a;
        }
        while (b-a>1){
            int mid = (a+b)/2;
            long x2 = mid*mid;
            if ((long)mid * mid > x){
                b = mid;
            }else if (mid==x){
                return mid;
            }else {
                a = mid;
            }
            if (b-a == 1){
                return a;
            }
        }

        return a;
    }


}
