package s207_myCanFinish;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        canFinish(4,new int[][]{{1,0},{2,0},{3,1}});
    }
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    Deque<Integer> steak;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        steak = new LinkedList<>();
        visited = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses&& valid; i++){
            if (visited[i] == 0){//未被搜索
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs(int node){
        visited[node] = 1;
        for (int v : edges.get(node)){
            if (visited[v] == 0){
                dfs(v);
            }
            if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        steak.push(node);
        visited[node] = 2;
    }
}
