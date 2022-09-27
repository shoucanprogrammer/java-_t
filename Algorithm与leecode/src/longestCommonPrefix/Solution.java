package longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs){
        int k = 0;
        int flag1 = 0 ;
        int length = strs.length;
        char[][] chars = new char[length][];
        int [] num = new int[length];
        if (length == 1){
            return strs[0];
        }
        for (int i=0; i<strs.length;i++){
            chars[i] = strs[i].toCharArray();
            num[i] = chars[i].length;
        }
        int min = num[0];
        for (int i =1;i<length;i++){
            if (min>num[i]){
                min = num[i];
            }
        }
        if (min==0)
            return "";
        for (int i=0;i<min;i++){
            char flag=chars[0][i] ;
            for (int j=1;j<length;j++){
                if (flag!=chars[j][i]){
                    flag1=1;
                }
            }
            k = i;
            if (flag1==1){
                break;
            }
        }
        if (k<1){
            if (flag1==0){
                return String.valueOf(chars[0][0]);
            }
            return "";

        }else {
            if (flag1==0)
                k=k+1;
            char[] last = new char[k];
            for (int x=0;x<k;x++){
                last[x] = chars[0][x];
            }
            return String.valueOf(last);
        }

    }
}
