package s481_magicalString;

public class Solution {
    public int magicalString(int n) {
        int m = n % 3;
        int k = n/3;
        if (m == 0 && k % 2 == 0){
            return 3 * k/2;
        }if (m == 0 && k % 2 == 1){
            return k/2 * 3  + 1;
        }
        else if (m != 0 && k % 2 == 0){ //不被整除 k为偶数
            return k/2 *3  + 1;
        }else {
            if (k % 2 == 1) {
                if (m == 1) {
                    return k / 2 * 3 + 1 + 1;
                } else {
                    return k / 2 * 3 + 1 + 2;
                }
            }else {
                if (m == 1) {
                    return k / 2 * 3 + 1;
                } else {
                    return k / 2 * 3 +1;
                }
            }
        }
    }
}
