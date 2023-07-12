package s537_complexNumberMultiply;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        complexNumberMultiply("1+1i","1+1i");
    }

    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num2.split("\\+|i");
        int real1 = Integer.parseInt(complex1[0]);
        int imag1 = Integer.parseInt(complex1[1]);
        int real2 = Integer.parseInt(complex2[0]);
        int imag2 = Integer.parseInt(complex2[1]);
//        System.out.printf("%d+%di", real1 * real2 - imag1 * imag2, real1 * imag2 + imag1 * real2);
        return String.format("%d+%di", real1 * real2 - imag1 * imag2, real1 * imag2 + imag1 * real2);
    }
}
