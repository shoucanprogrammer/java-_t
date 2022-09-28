package s28_strStr;

import org.junit.Test;

import java.util.Arrays;
public class Solution {
    @Test
    public void test(){
        int i = strStr("asaaasadbutsad", "aada");
        System.out.println();
    }
//    public int strStr1(String haystack,String needle){
//
//    }


    public int strStr(String haystack, String needle){
        int[] next = kmpNext(needle);
        System.out.println("next ="+ Arrays.toString(next));

        int index = kmpSearch(haystack,needle,next);
        return index;
    }
    public static int kmpSearch(String str1, String str2, int[] next){
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++ ){
            //需要处理str1.charAt(i) != str2.charAt(j),去调整j的大小
            //kmp算法核心点
            while (j>0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){//找到了
                return i - j + 1 ;
            }
        }
        return -1;
    }
    //获取到一个字符串（字串）的部分匹配值表
    public static int[] kmpNext(String dest){
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串长度为1 部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++){
            //当dest.charAt(i) == dest.charAt(j)满足时，部分匹配值就是+1
            //当dest.charAt(i) != dest.charAt(j),我们需要从next[j-1]获取新的j
            //知道我们发现有dest.chartAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while ( j>0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
