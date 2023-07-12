package s395_longgestSubstring;

class Solution {
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {  // t字符种类数目
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;//数量自加    //右边界
                if (cnt[s.charAt(r) - 'a'] == 1) { //新增字符
                    tot++;//种类自加
                    less++; //当某个字符的出现次数从 0 增加到 1时，将 less 加一
                }
                if (cnt[s.charAt(r) - 'a'] == k) { //字符达到情况
                    less--;//当某个字符的出现次数从 k−1 增加到 k 时，将 less\textit{less}less 减一。
                }

                while (tot > t) { //种类超过t --> 窗口滑动 l移动一整个字符  左边界
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;////当某个字符的出现次数从 k 减少到 k-1 时，将 less加一
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) { //移动完成
                        tot--;
                        less--;////从1到0  less --，
                    }
                    l++;
                }
                //不超过种类
                if (less == 0) {   //最大长度
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
