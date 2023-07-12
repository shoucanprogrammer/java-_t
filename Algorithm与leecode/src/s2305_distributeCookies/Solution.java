package s2305_distributeCookies;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        distributeCookies(new int[]{8,15,10,20,8},2);
    }
    private int Min = Integer.MAX_VALUE;
    private int[] sum ;
    public int distributeCookies(int[] cookies, int k) {
        sum = new int[k];
        traceBack(0,cookies,k);
        return Min;
    }
    public void traceBack(int start,int[] cookies,int k){
        if (start == cookies.length){
            int Max = 0;
            for(int i = 0; i < k; i++){
                Max = Math.max(Max,sum[i]);
            }
            Min = Math.min(Max,Min);
            return;
        }
            int i = start;
                for (int j = 0; j < k; j++){//分给k个人
                    if (sum[j] > Min){
                        return;
                    }
                    sum[j] += cookies[i];
                    if (sum[j] >= Min){
                        sum[j] -= cookies[i];
                        continue;
                    }
                    traceBack(i+1,cookies,k);
                    sum[j] -= cookies[i];
                }
    }
}
