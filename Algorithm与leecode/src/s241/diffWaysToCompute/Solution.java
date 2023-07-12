package s241.diffWaysToCompute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        diffWaysToCompute("2*3-4*5");
    }
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<Integer>();
        for (int i = 0; i < expression.length();) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        List<Integer> dfs = dfs(dp, 0, ops.size() - 1, ops);
        return dfs;
    }

    public List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {
                for (int i = l; i < r; i += 2) {
                    List<Integer> left = dfs(dp, l, i, ops);
                    List<Integer> right = dfs(dp, i + 2, r, ops);
                    for (int lv : left) {
                        for (int rv : right) {
                            if (ops.get(i + 1) == ADDITION) {
                                dp[l][r].add(lv + rv);
                            } else if (ops.get(i + 1) == SUBTRACTION) {
                                dp[l][r].add(lv - rv);
                            } else {
                                dp[l][r].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }
}
