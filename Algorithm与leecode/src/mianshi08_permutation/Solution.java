package mianshi08_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    StringBuilder tem = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public String[] permutation(String S) {
        boolean[] visited = new boolean[S.length()];
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        traceBack(chars,visited);
        String[] ansStr = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++){
            ansStr[i] = ans.get(i);
        }
        return ansStr;

    }
    public void traceBack(char[] chars,boolean[] visited){
        if (tem.length() == chars.length){
            ans.add(tem.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++){
            if (visited[i] || (i > 0 && !visited[i-1]&& chars[i-1]== chars[i] )){
                continue;
            }
            if (!visited[i]){
                tem.append(chars[i]);
                visited[i] = true;
                traceBack(chars,visited);
                tem.deleteCharAt(tem.length()-1);
                visited[i] = false;

            }
        }
    }
}
