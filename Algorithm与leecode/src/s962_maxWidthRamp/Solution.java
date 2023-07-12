package s962_maxWidthRamp;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
    }
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
