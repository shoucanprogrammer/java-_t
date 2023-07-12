package s67_addBinary;

//public class Solution {
//    @Test
//    public void test(){
//        String s = addBinary("110", "001");
//        System.out.println(s);
//    }
//    public String addBinary(String a, String b) {
//        return Integer.toBinaryString(
//                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
//        );
//    }
//}

import org.junit.Test;

public class Solution {
        @Test
    public void test(){
        String s = addBinary("100", "110010");
        System.out.println(s);
    }
    public String addBinary(String a, String b) {
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        int alength = a.length();
        int blength = b.length();
        int fla = 0;
        if (alength >= b.length()){
            char[] newchars = new char[alength];

            for (int i = alength-1,j = blength-1; i>=0;j--,i--){
                if (j>=0){
                    //进位标记
                    //需要进位
                    if ((a.charAt(i)=='1' && b.charAt(j) == '1') || ((a.charAt(i)=='1' ||b.charAt(j) == '1')&&fla ==1)){
                        if (fla == 0){
                            if (a.charAt(i) == '1' && b.charAt(j) == '1'){
                                newchars[i] = '0';
                                fla =1;
                                continue;
                            }
                        }else {
                            //fla ==1;
                            if ((a.charAt(i) == '1' && b.charAt(j) == '1')){
                                newchars[i] = '1';
                                fla =1;
                                continue;
                            }else {
                                newchars[i] = '0';
                                fla =1;
                                continue;
                            }
                        }
                        fla = 1;
                    }else {
                        //不需要进位
                        if ((((a.charAt(i)=='0' && b.charAt(j) == '1')||(a.charAt(i)=='1' && b.charAt(j) == '0'))&&fla==0)||a.charAt(i)=='0' && b.charAt(j) == '0'){
                            if (a.charAt(i)=='0' && b.charAt(j) == '0' && fla==0){
                                newchars[i] = '0';
                                fla = 0;
                                continue;
                            }else {
                                newchars[i] = '1';
                                fla = 0;
                                continue;
                            }
                        }
                        fla = 0;
                    }

                }else {
                    //只有a的时候 和fla
                    //需要进位
                    if (fla == 1 && a.charAt(i) == '1'){
                        fla=1;
                        newchars[i] = '0';
                    }else {
                        if (fla==1){
                            newchars[i] = '1';
                        }else {
                            newchars[i] = a.charAt(i);
                        }
                        fla = 0;
                    }
                }

            }
            //补一位
            if (fla == 1){

                char[] newchars1 = new char[alength+1];
                newchars1[0] = '1';
                for (int i = 0; i < alength; i++){
                    newchars1[i+1] = newchars[i];
                }
                return String.valueOf(newchars1);
            }
            return String.valueOf(newchars);

        }else {
            char[] newchars = new char[blength];

            for (int i = blength-1,j = alength-1; i>=0;j--,i--){
                if (j>=0){
                    //进位标记
                    //需要进位
                    if ((b.charAt(i)=='1' && a.charAt(j) == '1') || ((b.charAt(i)=='1' ||a.charAt(j) == '1')&&fla ==1)){
                        if (fla == 0){
                            if (b.charAt(i) == '1' && a.charAt(j) == '1'){
                                newchars[i] = '0';
                                fla =1;
                                continue;
                            }
                        }else {
                            //fla ==1;
                            if ((b.charAt(i) == '1' && a.charAt(j) == '1')){
                                newchars[i] = '1';
                                fla = 1;
                                continue;
                            }else {
                                newchars[i] = '0';
                                fla = 1;
                                continue;
                            }
                        }
                        fla = 1;
                    }else {
                        //不需要进位
                        if ((((b.charAt(i)=='0' && a.charAt(j) == '1')||(b.charAt(i)=='1' && a.charAt(j) == '0'))&&fla==0)||(b.charAt(i)=='0' && a.charAt(j) == '0')){
                            if (b.charAt(i)=='0' && a.charAt(j) == '0' && fla==0){
                                newchars[i] = '0';
                                fla = 0;
                                continue;
                            }else {
                                newchars[i] = '1';
                                fla = 0;
                                continue;
                            }
                        }
                        fla = 0;
                    }

                }else {
                    //只有a的时候 和fla
                    //需要进位
                    if (fla == 1 && b.charAt(i) == '1'){
                        fla=1;
                        newchars[i] = '0';
                    }else {
                        if (fla==1){
                            newchars[i] = '1';
                        }else {
                            newchars[i] = b.charAt(i);
                        }
                        fla = 0;

                    }
                }

            }
            //补一位
            if (fla == 1){

                char[] newchars1 = new char[blength+1];
                newchars1[0] = '1';
                for (int i = 0; i < blength; i++){
                    newchars1[i+1] = newchars[i];
                }
                return String.valueOf(newchars1);
            }
            return String.valueOf(newchars);

        }
    }
}


