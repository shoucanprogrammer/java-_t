package s401_readBinaryWatch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        readBinaryWatch(3);
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }



    int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch1(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }

    public void backtrack(int num, int index, int hour, int minute){
        if(hour > 11 || minute > 59)
            return;

        if(num == 0){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for(int i = index; i < 10; i++){
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }


}
