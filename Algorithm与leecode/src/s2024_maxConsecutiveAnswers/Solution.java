package s2024_maxConsecutiveAnswers;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    @Test
    public void test(){
        maxConsecutiveAnswers("TTFTTFTT",1);
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] count = new int[2];
        int ans = 0;
        int r = 0;
        int l = 0;
        while (r < answerKey.length()){
            if ((count[1] >=k+1 && count[0] == k+1)||(count[0] >=k+1 && count[1] == k+1)){ //满了
                ans = Math.max(ans,count[0] + count[1] -1);
                if (answerKey.charAt(l) == 'F'){
                    count[1]--;
                }else {
                    count[0]--;
                }
                l++;
            }else {
                if (answerKey.charAt(r) == 'F'){
                    count[1]++;
                }else {
                    count[0]++;
                }
                r++;
            }
        }
        if ((count[1] >=k+1 && count[0] == k+1)||(count[0] >=k+1 && count[1] == k+1)){ //满了
            ans = Math.max(ans,count[0] + count[1] -1);
            return ans;
        }

        return Math.max(ans,count[0] + count[1] );
    }
}
