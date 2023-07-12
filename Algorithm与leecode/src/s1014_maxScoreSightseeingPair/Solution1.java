package s1014_maxScoreSightseeingPair;

public class Solution1 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int max = values[0] + 0;
        for (int i = 1; i < n; i++){
            ans = Math.max(ans,values[i]  + max -i);
            max = Math.max(max,values[i] + i);
        }
        return ans;
    }
}
