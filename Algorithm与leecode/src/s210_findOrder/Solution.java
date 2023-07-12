package s210_findOrder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        findOrder(2,new int[][]{{1,0}});
    }
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    int[] result;
    int num;
    Deque<Integer> steak;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        num = numCourses-1;
        result = new int[numCourses];
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        steak = new LinkedList<Integer>();

        for (int i = 0; i < prerequisites.length; i++){
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses&& valid; i++){
            if (visited[i] == 0){//未被搜索
                dfs(i);
            }
        }
        if (valid){
            return result;
        }
        return new int[]{};
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
        result[num--] = node;
        visited[node] = 2;
    }
}
