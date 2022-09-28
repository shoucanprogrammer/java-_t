package s12_intToRoman;

import org.junit.Test;
public class Solution {
    @Test

    public void test(){
        intToRoman(6);
    }
    public String intToRoman(int num){
        int remainder;
        int count = 1;
        String roman = "";
        while (num>=1){
            remainder = num%10;

            roman = getRoman(remainder, count).concat(roman);
            num = num/10;
            count++;
        }
        return roman;

    }
    public String getRoman(int remainder,int count){
        if (count == 1){
            if (remainder == 4){
                return "IV";
            }
            if (remainder == 9){
                return "IX";
            }
            if (remainder<4){
                String s = "";
                for (int i = 0; i < remainder; i++){
                     s=s.concat("I");

                }
                return s;
            }
            if (remainder == 5){
                return "V";
            }
            if (remainder>=6 &&remainder<9){
                String s = "V";
                for (int i = 0; i < remainder-5; i++){
                    s=s.concat("I");

                }
                return s;
            }

        }
        if (count == 2){
            if (remainder == 4){
                return "XL";
            }
            if (remainder == 9){
                return "XC";
            }
            if (remainder<4){
                String s = "";
                for (int i = 0; i < remainder; i++){
                    s=s.concat("X");

                }
                return s;
            }
            if (remainder == 5){
                return "L";
            }
            if (remainder>=6 &&remainder<9){
                String s = "L";
                for (int i = 0; i < remainder-5; i++){
                    s=s.concat("X");

                }
                return s;
            }
        }
        if (count == 3){
            if (remainder == 4){
                return "CD";
            }
            if (remainder == 9){
                return "CM";
            }
            if (remainder<4){
                String s = "";
                for (int i = 0; i < remainder; i++){
                    s=s.concat("C");

                }
                return s;
            }
            if (remainder == 5){
                return "D";
            }
            if (remainder>=6 &&remainder<9){
                String s = "D";
                for (int i = 0; i < remainder-5; i++){
                    s=s.concat("C");

                }
                return s;
            }
        }
        if (count == 4){
            if (remainder<4){
                String s = "";
                for (int i = 0; i < remainder; i++){
                    s=s.concat("M");

                }
                return s;
            }

        }
        return null;
    }

}
