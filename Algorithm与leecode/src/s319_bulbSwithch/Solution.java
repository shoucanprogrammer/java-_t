package s319_bulbSwithch;

import java.util.Arrays;

public class Solution {
    public int bulbSwitch(int n ){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        boolean[] fla = new boolean[n];
        Arrays.fill(fla,true);
        for (int i = 1; i < n; i += 2){
            fla[i] = false;
        }
        int k = 3;
        while (k <= n){
            for (int i = k-1; i < n; i += k){
                fla[k] = !fla[k];
            }
            k++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            if (fla[i] == true){
                ans++;
            }
        }

    return ans;
    }

}
