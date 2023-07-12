package s1774_closestCost;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        closestCost(new int[]{1},new int[]{8,10},10);
    }
    private int ans = Integer.MAX_VALUE;
    private int minRes = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int i = 0; i < baseCosts.length; i++){
            traceBack(toppingCosts,0,baseCosts[i],target);
        }
        return ans;
    }
    public void traceBack(int[] toppingCosts,int i,int cost,int target){
        if (Math.abs(target - cost) < Math.abs(target-ans)){
            ans = cost;
        }else if (Math.abs(target - cost) == Math.abs(target-ans)){
            ans = Math.min(cost,ans);
        }
        if (i == toppingCosts.length){
            return;
        }
        //加入配料
        traceBack(toppingCosts,i+1,cost,target);  //不加
        traceBack(toppingCosts,i+1,cost+toppingCosts[i],target);//加一
        traceBack(toppingCosts,i+1,cost+2*toppingCosts[i],target);//加二
    }
}
