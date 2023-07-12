package s526_countArrangement;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        countArrangement(4);
    }
    boolean[] used;
    int ans ;
    public int countArrangement(int n) {
        used = new boolean[n+1];
        ans = 0;
        tracekBack(0,n);
        return ans;
    }
    public void tracekBack(int num,int n){
        if (num == n){
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++){
            if (used[i] == false &&(i%(num+1)==0 || (num+1)%i==0)){
                used[i] = true;
                tracekBack(num+1,n);
                used[i]  = false;
            }

        }
    }

}
