package s1423_maxScore;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        maxScore(new int[]{1,2,3,4,5,6,1},3);
    }
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++){
            sum += cardPoints[i];
        }
        int minRes = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < cardPoints.length - k; i++){
            res += cardPoints[i];
        }
        minRes = res;
        for(int i = 0; i < k ; i++){
            res = res - cardPoints[i] + cardPoints[i+cardPoints.length - k];
            minRes = Math.min(res,minRes);
        }
    return  sum - minRes;
    }
}
