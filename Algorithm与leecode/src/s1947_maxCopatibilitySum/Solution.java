package s1947_maxCopatibilitySum;

public class Solution {
    int ans = 0;
    boolean[] used;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        used = new boolean[mentors.length];
        traceBack(0,students,mentors,0);
        return ans;
    }
    public void traceBack(int i,int[][] students,int[][] mentors,int grades){
        if (i == students.length){
            ans = Math.max(ans,grades);
            return;
        }
        for (int j = 0; j < mentors.length; j++){//将学生i分给那个老师
            int num = 0;
            if (!used[j]){
                used[j] = true;
                for (int  k = 0; k < students[0].length;k++){
                    if (students[i][k] == mentors[j][k]){
                        num++;
                    }
                }
                traceBack(i+1,students,mentors,grades+num);
                used[j] = false;
            }
        }

    }
}
