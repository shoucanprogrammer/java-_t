package s3_romanToInt;

public class romanToInt {
    public int romanToInt(String s){
        char[] romannumber = s.toCharArray();
        int number = 0;
        for (int i =0;i< romannumber.length;i++){
            if ( romannumber[i]=='I'){
                if (i+1<romannumber.length&&romannumber[i+1] =='V'){
                    i++;
                    number+=4;
                    continue;
                }
                if (i+1<romannumber.length&&romannumber[i+1] =='X'){
                    i++;
                    number+=9;
                    continue;
                }
                else {
                    number+=1;
                    continue;
                }
            }
            if (romannumber[i]=='X'){
                if (i+1<romannumber.length&&romannumber[i+1] =='L'){
                    i++;
                    number+=40;
                    continue;
                }
                if (i+1<romannumber.length&&romannumber[i+1] =='C'){
                    i++;
                    number+=90;
                    continue;
                }
                else {
                    number+=10;
                    continue;
                }
            }
            if (romannumber[i]=='C'){
                if (i+1<romannumber.length&&romannumber[i+1] =='D'){
                    i++;
                    number+=400;
                    continue;
                }
                if (i+1<romannumber.length&&romannumber[i+1] =='M'){
                    i++;
                    number+=900;
                    continue;
                }
                else {
                    number+=100;
                    continue;
                }
            }
            if (romannumber[i] =='V'){
                number+=5;
                continue;
            }
            if (romannumber[i] =='L'){
                number+=50;
                continue;
            }
            if (romannumber[i] =='D'){
                number+=500;
                continue;
            }
            if (romannumber[i] =='M'){
                number+=1000;
                continue;
            }
        }
        return number;
    }
}
