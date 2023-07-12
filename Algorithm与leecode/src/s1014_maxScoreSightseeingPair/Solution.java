package s1014_maxScoreSightseeingPair;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int value = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                value = values[i] + values[j] - ( j - i);
                ans = Math.max(ans,value);
            }
        }
        return ans;
    }
}
