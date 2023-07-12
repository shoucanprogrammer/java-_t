package s1129_shortestAlternatingPaths;

import java.util.*;

public class Solution {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        //next[0] 存放 红色有向
        //next[1] 存放 蓝色有向
        // 数组2下标标识当前点，对应存放的list是当前点能够到达的点
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<>();
            }
        }
        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }
        // 两种类型的颜色 分别从0到对应下标的最短路径的长度
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            //填充max
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        //到达0位置的路径始终为0
        dist[0][0] = 0;
        dist[1][0] = 0;

        //两种初始路线 0是可达位置 1 是否蓝色
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            // x 目标节点 t 是否蓝色
            int x = pair[0], t = pair[1];
            //在已知的路线中，当前点x在 1-t（要么是0要么是1）这个颜色下的可达目标，即以当前点为根，对所有下一级可达低点进行广度优先搜索
            // x为当前节点y为x的下级节点
            for (int y : next[1 - t][x]) {
                //1-t这个颜色下到达点y的最短路径已经有值，则不再次计算
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    //已经经过了这个点
                    continue;
                }
                //在其他点通过颜色t到达点x的基础上+1 得到1-t颜色到达点y的最小步数
                dist[1 - t][y] = dist[t][x] + 1;
                //当前节点x处理完毕，将所有下级节点y放入待处理队列中
                queue.offer(new int[]{y, 1 - t});
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            //又两种颜色分别进行广度优先搜索拿到的距离取其最短的那一种
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            //如果没有可达路线 就是-1
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;

    }
}
