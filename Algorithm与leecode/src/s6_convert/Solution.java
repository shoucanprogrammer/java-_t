package s6_convert;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    @Test
    public void  test(){
        String s = "AB";
        int numRows = 1;
        convert4(s,numRows);
    }
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int r = numRows;
        int n = s.length();
        int curnum = 0;
        int curcounter = 1;
        int i = 0;
        LinkedList[] list = new LinkedList[numRows];
        for (int j = 0 ; j < numRows; j++){
            list[j] = new LinkedList();
        }
        if (numRows == 2){
            while (curnum < n){
                list[i].add(String.valueOf((s.charAt(curnum))));
                curnum++;
                i++;
                if (i == numRows){
                    i =0;
                }
            }
            String s1 = new String();
            for ( i = 0; i < numRows; i++){
                for (int j = 0; j < list[i].size(); j++){
                    s1 = s1+list[i].get(j);
                }
            }
            return s1;
        }
        while (curnum < n){
            if (curcounter % (numRows*(numRows-1)) <= numRows && curcounter % (numRows*(numRows-1)) > 0){
                list[i].add(String.valueOf((s.charAt(curnum))));
                curnum++;
            }else{
                int fla = curnum;
                while (r>2){
                    if (curcounter % (numRows*(numRows-1)) == ((numRows- r + 2)*numRows + r -numRows -1 )){
                        list[i].add(String.valueOf((s.charAt(curnum))));
                        curnum++;
                    }
                    r--;
                }
                r = numRows;
                if (fla == curnum){
                    list[i].add(" ");
                }
            }
            curcounter++;
            i++;
            if (i == numRows){
                i =0;
            }
        }
        String s1 = new String();
        for ( i = 0; i < numRows; i++){
            for (int j = 0; j < list[i].size(); j++){
                if (list[i].get(j) != " "){
                    s1 = s1+list[i].get(j);
                }
            }
        }
        return s1;
    }

    public String convert1(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }


    public String convert3(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[r];
        for (int i = 0; i < r; ++i) {
            mat[i] = new StringBuffer();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }

    public String convert4(String s, int numRows) {
        int sn = s.length();
        int t = 2*numRows -2;
        if (numRows == 1){
            return s;
        }
        StringBuffer[] mat = new StringBuffer[numRows];
        for (int i =0 ; i < numRows; i++){
            mat[i] = new StringBuffer();
        }

        for (int i = 0,x = 0; i < sn; i++){
            mat[x].append(s.charAt(i));
            if (i % t < numRows-1){
                x++;
            }else{
                x--;
            }
        }
        StringBuffer s1 = new StringBuffer();
        for (int i = 0; i < numRows; i++ ){
            s1.append(mat[i]);
            }

        return s1.toString();
    }



}
