package s3_lengthOfLongestSubstring;

import org.testng.annotations.Test;

import java.util.*;

public class S3_lengthOfLongestSubstring {
    @Test
    public void test(){
        String s = "aacdea";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
    @Test
    public void test2(){
        String s = "aacdeaaa";
        int length = lengthOfLongestSubstring1(s);
        System.out.println(length);
    }
    @Test
    public void test3(){
        String s = "aacdeaaa";
        int length = lengthOfLongestSubstring1(s);
        System.out.println(length);
    }

    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        LinkedList list = new LinkedList();
        char[] chars = s.toCharArray();
        int maxsize = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++){
            if (!list.contains(chars[i])){
                list.addLast(chars[i]);
            }else if (list.contains(chars[i])){
                while (list.contains(chars[i])){
                    list.remove(0);
                }
                list.addLast(chars[i]);
            }
            num = list.size();
            if (num > maxsize){
                maxsize = num;
            }

        }
        return maxsize;
    }

    public int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int r = -1;
        int len = 0;
        for (int i = 0; i < n; i++){
            if (i != 0){
                occ.remove(s.charAt(i-1));
            }
            while (r+1 < n && !occ.contains(s.charAt(r+1))){
                occ.add(s.charAt(r+1));
                r++;
            }
            len = Math.max(len,r+1-i);
        }
        return len;
    }


}


