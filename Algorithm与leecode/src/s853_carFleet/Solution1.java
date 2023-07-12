package s853_carFleet;

import java.util.Arrays;

public class Solution1 {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] ps = new int[len][2];
        for (int i = 0; i < len; i++) {
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }
        Arrays.sort(ps, (a, b) -> (b[0] - a[0]));
        double k;
        double[] kArr = new double[len];
        for (int i = 0; i < len; i++) {
            k = (1.0*target - ps[i][0]) / ps[i][1];
            kArr[i] = k;
        }
        k = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (kArr[i] > k) {
                ans++;
                k = kArr[i];
            }
        }
    return ans;
    }
}
