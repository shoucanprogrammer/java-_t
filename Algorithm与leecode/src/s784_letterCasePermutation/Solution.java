package s784_letterCasePermutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean used[];
    private List<String> ans = new LinkedList<>();
    public List<String> letterCasePermutation(String s) {
        used = new boolean[s.length()];
        int wordNum = 0;
        for (int i = 0; i < s.length(); i++){
            if (Character.isLetter(s.charAt(i))){
                wordNum++;
            }
        }
//        ans.add(s);
        dfs(0,0,wordNum,s.toCharArray());
        return ans;
    }

    public void dfs(int k ,int start, int wordNum,char[] s){
        ans.add(new String(s));
        if (start == wordNum){
            return;
        }
        for (int i = k; i < s.length; i++){
            if (used[i] == false && Character.isLetter(s[i])){//改变大小写
                used[i] = true;
                if ('a'<=s[i]&&s[i]<='z'){
                    s[i] = (char) (s[i]-32);
//                    ans.add(new String(s));
                    dfs(i+1,start+1,wordNum,s);
                    s[i] = (char) (s[i]+32);
                }else {
                    used[i] = true;
                    s[i] = (char) (s[i]+32);
//                    ans.add(new String(s));
                    dfs(i+1,start+1,wordNum,s);
                    s[i] = (char) (s[i]-32);
                }
            }
            used[i] = false;

        }
    }


}
