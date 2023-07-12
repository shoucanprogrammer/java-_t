package Offr38_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<String> tem = new ArrayList<>();
    StringBuilder  stringBuilder = new StringBuilder();
    public String[] permutation(String s) {
        int n = s.length();
        boolean[] fla = new boolean[n];
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars);
        traceBack(chars,0,fla);
        int size = tem.size();
        String[] res = new String[size];
        int i = 0;
        for (String str : tem){
            res[i++] = str;
        }
        return res;
    }

    //回溯
    public void traceBack(char[] chars, int count, boolean[] fla){
        if (stringBuilder.length() == chars.length) {
            tem.add(stringBuilder.toString());
        }
        for (int i = 0; i < chars.length; i++ ) {
            if (fla[i] == true){
                continue;
            }
            stringBuilder.append(chars[i]);
            fla[i] = true;
            traceBack(chars,count + 1, fla);
            fla[i] = false;
            stringBuilder.deleteCharAt(count);
            //去重
            while ( i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
            }

        }

    }
}
