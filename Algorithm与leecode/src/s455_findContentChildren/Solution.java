package s455_findContentChildren;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        int j = g.length-1;
        for (int i = s.length-1; i >=0; i--){
            for (; j >=0; j--){
                if (s[i]>=g[j]&&g[j]>0){
                    sum ++;
                    j--;
                    break;
                }
                if (j==0){
                    return sum;
                }
            }
        }
    return sum;
    }
}
