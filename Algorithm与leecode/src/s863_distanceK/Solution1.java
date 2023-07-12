package s863_distanceK;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    int k1 = 0;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        k1= k;
        //创建邻接表
        List<Integer>[] graph =new List[501];
        for (int i = 0; i < 501; i++){
            graph[i] = new ArrayList<Integer>();
        }
        //中序遍历创建无向graph
        mid(root,graph);
        //深度遍历目标节点
        boolean[] visited  =  new boolean[501];
        visited[target.val] = true;
        //深度遍历图
        dfs(target.val,graph,visited,0);
        return ans;
    }

    public void mid(TreeNode root,List[] lists){
        if (root.left != null){
            lists[root.val].add(root.left.val);
            lists[root.left.val].add(root.val);
            //递归
            mid(root.left,lists);
        }
        if (root.right != null){
            lists[root.val].add(root.right.val);
            lists[root.right.val].add(root.val);
            mid(root.right,lists);
        }

    }
    public void dfs(int i ,List<Integer>[] graph,boolean[] vised,int h){
        if (h == k1){
            ans.add(i);
            return;
        }
        for (int num: graph[i]){
            if (!vised[num]){
                vised[num] = true;
                dfs(num,graph,vised,h+1);
            }
        }
    }

}
