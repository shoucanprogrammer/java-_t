package s684_findRedundantConnection;

public class Solution1 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n+1];
        for (int i = 1; i < n+1; i++){
            parents[i] = i;
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            if (find(parents,node1) != find(parents,node2)){
                //合并
                union(parents,node1,node2);

            }else {
                return edge;
            }
        }
        return new int[]{};
    }
    public void union(int[] parents,int node1,int node2){
        parents[find(parents,node1)] = find(parents,node2);
    }
    public int find(int[] parents, int node){
        if (parents[node] != node){
            parents[node] = find(parents,parents[node]);
        }
        return parents[node];
    }
}
