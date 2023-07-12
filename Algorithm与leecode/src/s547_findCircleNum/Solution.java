package s547_findCircleNum;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++){
            if (!visited[i]){
                dfs(isConnected,visited,cities,i);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected,boolean[] visited,int cities,int i){
        for (int j = 0; j < cities; j ++){
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,cities,j);
            }
        }
    }
}
