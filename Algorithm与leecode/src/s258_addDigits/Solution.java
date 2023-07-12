package s258_addDigits;

public class Solution {

    public int addDigits(int num) {
        int sum = 0;
        while (true){
            num = num / 10;
            sum += num % 10;;
            if (sum < 10 && num == 0){
                break;
            }else if (num == 0){
                num = sum;
                sum = 0;
            }
        }
    return sum;
    }
}
