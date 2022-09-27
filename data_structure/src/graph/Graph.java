package graph;

import List.Linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    private boolean[] isVisited;
    public static void main(String[] args) {
        //测试
        int n = 5;//结点的个数
        String Vertexs[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        for(String vertex : Vertexs){
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //显示一把邻接矩阵
        graph.showGraph();
        //测试
        System.out.println("DFS:");
        graph.dfs();
        System.out.println();
        System.out.println("BFS:");
        graph.bfs();

    }
    //构造器
    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;

    }
    //得到第一个邻接结点的下标w
    public int getFirstNeighbor(int index){
        for (int j = 0; j < vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int j= v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    // i 第一次就是0
    public void dfs(boolean[] isVisited, int i){
        //首先我们访问该结点，输出
        System.out.print(getValueByIndex(i)+"->");
        //将结点设置为已经访问过
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1){//说明有
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs(){
        isVisited = new boolean[5];
        //遍历所有点的结点，进行dfs[回溯]
        for(int i = 0; i <getNumOfEVertex(); i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i){
        int u; //表示队列的头结点对应的下标
        int w;//邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点的信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u = (Integer)queue.removeFirst();
            //得到一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w!= -1){//找到
                //是否访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u 为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u, w);//体现出我们的广度优先
                }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        isVisited = new boolean[5];
        for (int i = 0; i < getNumOfEVertex(); i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfEVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i对应的数据 0->“A”  1->"B" 2->"C"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回V1 V2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /***
     *
     * @param v1 表示点的小标即第几个顶点 “A”-“B” “A”=>0 "B"->1
     * @param v2 第二个顶点对应
     * @param weight
     */
    //添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }

}
