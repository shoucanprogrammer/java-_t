package s1415_getHappyString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        getHappyString(1,2);
    }
    private int N = 0;
    private int K = 0;
    private List<List<Character>> ans = new ArrayList<>();
    private List<Character> res = new ArrayList<>();
    public String getHappyString(int n, int k) {
        N = n;
        K =k;
        traceBack(-1);
        int size = ans.size();
        if (size== K){
            StringBuffer buffer = new StringBuffer();
            for (Character character : ans.get(size-1)){
                buffer.append(character);
            }
            return buffer.toString();
        }else {
            return "";
        }
    }
    public void traceBack(int last ){
        if (res.size() == N){
            ans.add(new ArrayList(res));
            return;
        }
        for (int i = 0; i <= 2; i++){
            if (ans.size() == K){
                break;
            }else {
                if (last != i){
                    res.add((char)('a'+i));
                    traceBack(i);
                    res.remove(res.size()-1);
                }
            }
        }
    }
}
