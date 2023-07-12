package s241.diffWaysToCompute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    @Test
    public void test(){
        diffWaysToCompute("10+5");
    }
    static final int ADD = -1;
    static final int SUB = -2;
    static final int MUL = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        int len = expression.length();
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < len; ){
            char c = expression.charAt(i);
            if (c == '+'){
                ops.add(ADD);
                i++;
            }else if (c == '-') {
                ops.add(SUB);
                i++;
            }else if (c == '*'){
                ops.add(MUL);
                i++;
            }else {
                int t = 0;

                while (i < len && Character.isDigit(expression.charAt(i))){
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);

            }
        }
        List<Integer>[][] dp = new ArrayList[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++){
            for (int j = 0; j < ops.size(); j ++){
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        List<Integer> dfs = dfs(dp, 0, ops.size() - 1, ops);
        return dfs;
    }
    List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops){
        if (dp[l][r].isEmpty()){
            if (l == r){
                dp[l][r].add(ops.get(l));
                return dp[l][r];
            }
            for (int i = l; i < r; i += 2){
                List<Integer> lefts = dfs(dp,l,i,ops);
                List<Integer> rights = dfs(dp,i+2,r,ops);
                for (int left : lefts){
                    for (int right : rights){
                        if (ops.get( i + 1 ) == ADD){
                            dp[l][r].add(left + right);
                        }else if (ops.get( i + 1 ) == SUB){
                            dp[l][r].add(left - right);
                        }else if (ops.get(i+1) == MUL){
                            dp[l][r].add(left*right);
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }
}
