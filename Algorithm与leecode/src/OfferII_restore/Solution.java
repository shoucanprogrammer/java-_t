package OfferII_restore;

import java.util.ArrayList;
import java.util.List;
public class Solution{
    int n;
    List<String> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        dfs(s, 0);
        return ans;
    }

    void dfs(String s, int i) {
        // 剪枝，ip段数等于4时返回，不再递归下一层
        if (temp.size() == 4) {
            // 全部遍历完成即为解
            if (i == n) ans.add(restoreIp(temp));
            return;
        }
        // 剪枝，实现最多取3个数字
      int most = Math.min(i+3,n);
        for (int j = i;  j < most; j++){
            String str = s.substring(i,j+1);
            int num = Integer.valueOf(str);
            if (str.charAt(0) =='0'&& str.length()>1 ||num<0||num>255) break;
            temp.add(str);
            dfs(s, j + 1);
            temp.remove(temp.size() - 1);
        }

    }

    // 拼接ip
    String restoreIp(List<String> temp) {
        StringBuilder sb = new StringBuilder();
        int size = temp.size();
        for (int i = 0; i < size; i++) {
            sb.append(temp.get(i));
            if (i < size - 1) sb.append(".");
        }
        return sb.toString();
    }
}