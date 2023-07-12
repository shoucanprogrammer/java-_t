package s1031_maxSumTwoNoOverlap;

class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length < L + M) {
            return 0;
        }
        //滑动窗口过程中的和
        int tempSum = 0;
        //dp数组，记录滑动窗口和
        int[][] dp = new int[4][A.length];
        //第一组滑动窗口
        //左边L个，开始滑动
        for (int i = 0; i < L; i++) {
            tempSum = tempSum + A[i];
        }
        dp[0][L-1] = tempSum;
        for (int i = L; i < A.length; i++) {
            tempSum = tempSum - A[i - L] + A[i];
            dp[0][i] = Math.max(dp[0][i-1], tempSum);
        }
        //右边M个开始滑动
        tempSum = 0;
        for (int i = A.length - 1; i >= A.length - M; i--) {
            tempSum += A[i];
        }
        dp[1][A.length - M] = tempSum;
        for (int i = A.length - M - 1; i >= 0; i--) {
            tempSum = tempSum - A[i + M] + A[i];
            dp[1][i] = Math.max(dp[1][i + 1], tempSum);
        }
        //第二组滑动窗口
        //左边M个，开始滑动
        tempSum = 0;
        for (int i = 0; i < M; i++) {
            tempSum = tempSum + A[i];
        }
        dp[2][M-1] = tempSum;
        for (int i = M; i < A.length; i++) {
            tempSum = tempSum - A[i - M] + A[i];
            dp[2][i] = Math.max(dp[2][i-1], tempSum);
        }
        //右边L个开始滑动
        tempSum = 0;
        for (int i = A.length - 1; i >= A.length - L; i--) {
            tempSum += A[i];
        }
        dp[3][A.length - L] = tempSum;
        for (int i = A.length - L - 1; i >= 0; i--) {
            tempSum = tempSum - A[i + L] + A[i];
            dp[3][i] = Math.max(dp[3][i + 1], tempSum);
        }
        //开始计算最大值，第一组滑动窗口最大值，第二组滑动窗口最大值，取两个值的最大值
        int res = 0;
        for (int i = L; i <= A.length - M; i++) {
            if (dp[0][i - 1] + dp[1][i] > res) {
                res = dp[0][i - 1] + dp[1][i];
            }
        }
        for (int i = M; i <= A.length - L; i++) {
            if (dp[2][i - 1] + dp[3][i] > res) {
                res = dp[2][i - 1] + dp[3][i];
            }
        }
        System.out.println(res);
        return res;
    }
}

