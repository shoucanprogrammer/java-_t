package s1002_commonChars;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> commonChars(String[] A) {
        int[] arr = count(A[0]); // 统计第一个字符串内字符的出现频率
        for (int i = 1; i < A.length; i++) {
            //统计除第一个字符串外字符的出现频率
            //更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            intersection(arr, count(A[i]));
        }
        List<String> res = new ArrayList<>();
        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (arr[i]-- >0){ // 注意这里是while，多个重复的字符
                res.add(String.valueOf((char)(i+'a')));
            }
        }
        return res;
    }

    public void intersection(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            a[i] = Math.min(a[i], b[i]);
        }
    }

    int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }
}