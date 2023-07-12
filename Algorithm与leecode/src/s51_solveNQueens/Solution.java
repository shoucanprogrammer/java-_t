package s51_solveNQueens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        solveNQueens(4);
    }
    List<List<String>> ret ;
    List<String> ans ;
    boolean[][] mat;
    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        mat = new boolean[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(mat[i],false);
        }
         //可已经放置的位置
        dfsQueens(0,n);
        return ret;
    }

    public void dfsQueens(int step,int n){
        if (step == n){
            ans = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < n; j++){
                    if (mat[i][j] == true){
                        buffer.append("Q");
                    }else {
                        buffer.append(".");
                    }
                }
                ans.add(buffer.toString());
            }
            ret.add(ans);
            return;
        }
            int i = step;
            for (int j = 0; j < n; j++){
                boolean fla = true;
                int lh = i -1;
                while (lh>=0){//下探索
                    if (mat[lh][j] == true){
                        fla = false;
                        break;
                    }
                    lh--;
                }
                if (fla == false){
                    continue;
                }
                int rh = i +1;
                while (rh<n){//上探索

                    if (mat[rh][j] == true){
                        fla = false;
                        break;
                    }
                    rh++;
                }
                if (fla == false){
                    continue;
                }
                int uh = j +1;
                while (uh<n){//右
                    if (mat[i][uh] == true){
                        fla = false;
                        break;
                    }
                    uh++;
                }
                if (fla == false){
                    continue;
                }
                int dh = j - 1;
                while (dh>=0){//左
                    if (mat[i][dh] == true){
                        fla = false;
                        break;
                    }
                    dh--;
                }
                if (fla == false){
                    continue;
                }
                //对角线
                uh = j + 1;
                rh = i + 1;
                while (uh<n && rh<n){//上
                    if (mat[rh][uh] == true){
                        fla = false;
                        break;
                    }
                    uh++;
                    rh ++;
                }
                if (fla == false){
                    continue;
                }
                //对角线
                dh = j - 1;
                lh = i - 1;
                while (dh>=0 && lh>=0){//上
                    if (mat[lh][dh] == true){
                        fla = false;
                        break;
                    }
                    dh--;
                    lh--;
                }
                if (fla == false){
                    continue;
                }
                //对角线
                uh = j + 1;
                lh = i - 1;
                while (uh<n && lh>=0){//上
                    if (mat[lh][uh] == true){
                        fla = false;
                        break;
                    }
                    uh++;
                    lh --;
                }
                if (fla == false){
                    continue;
                }
                //对角线
                dh = j - 1;
                lh = i - 1;
                while (dh>=0 && lh>=0){//上
                    if (mat[lh][dh] == true){
                        fla = false;
                        break;
                    }
                    dh--;
                    lh --;
                }
                if (fla == false){
                    continue;
                }
            if (fla == true){
                mat[i][j] = true;
                dfsQueens(step+1,n);
                mat[i][j] = false;
            }

        }
    }
}
