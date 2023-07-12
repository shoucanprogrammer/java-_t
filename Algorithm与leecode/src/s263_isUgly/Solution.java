package s263_isUgly;

public class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] facts = new int[]{2,3,5};
        for (int fact : facts){
            while (n % fact == 0){
                n /= fact;
            }
        }
        return n == 1;
    }
}
