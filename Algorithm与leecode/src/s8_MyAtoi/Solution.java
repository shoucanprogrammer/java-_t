package s8_MyAtoi;


import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        myAtoi("  +  413");
    }
    public int myAtoi(String s){
        int len = s.length();
        if (len == 0){
            return 0;
        }
        int count = 0;
        int fla = 1; //标记符号位 正负
        int fla1 = 0;//标记是否溢出
        int fla2 = 0;//标记符号位是否出现
        int n = 0; //标记数字位位数
        while (true){
            char c = s.charAt(count);
            if (' '==(s.charAt(count))){
                if (n>0){
                    break;
                }
                if (fla2>0)
                    break;
                count++;  //移动有效位置
            }else {
                if ('-'==(s.charAt(count))){
                    if (fla2==1)
                        break;
                    fla = 0;
                    fla2 = 1;
                    count++;
                }else if ('+'==(s.charAt(count))){
                    if (fla2 == 1)
                        break;
                    fla = 1;
                    fla2 = 1;
                    count++;
                }else if (48<=s.charAt(count)&&s.charAt(count)<=57){
                    fla2 = 1;
                    count++;
                    n++;
                }else {
                    break;
                }
            }
            if (count>=len){
                break;
            }
        }
        int x = 0;
        int x2 = 0;
        for (int i = count-n;i<count;i++){
            char c = s.charAt(i);
            x2 = x;
            if ((x*10 + c-48)/10 == x2){
                x = x*10 + c-48;
            }else {
                fla1 = 1;
                break;
            }
        }
        if (fla == 0){
            if (fla1 == 1)
                return -2147483648;
            return -x;
        }
        if (fla1 == 1){
            return 2147483647;
        }
        return x;
    }
}
