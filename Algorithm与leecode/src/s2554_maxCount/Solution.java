package s2554_maxCount;

import java.util.HashSet;

public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++){
            set.add(banned[i]);
        }
        int sum = 0;
        int con = 0;
        for (int i = 1; i <= n; i++){
            if (!set.contains(i)){
                sum += i;
                if (sum <= maxSum){
                    con++;
                }else {
                    break;
                }

            }
        }
        return con;
    }
}
