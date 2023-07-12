package s264_nthUglyNumber;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = new int[]{2,3,5};
        int count = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++){
            int k = i;
            for (int factor : factors){
                while (k % factor==0){
                    k /= factor;
                }
            }
            if (k == 1){
                count++;
            }
            if (count == n){
                return i;
            }
        }
        return 0;
    }
}
