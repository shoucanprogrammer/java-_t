package s397_integerReplacement;

public class Solution {
    public int integerReplacement(int n){
        if (n == 1){
            return 0;
        }
        if (n % 2 == 0){
            return 1 + integerReplacement(n / 2);
        }
        return Math.min(integerReplacement(n/2),integerReplacement(n/2+1))+2;
    }
}
