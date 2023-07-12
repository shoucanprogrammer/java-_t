package s841_canVisitAllRooms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    @Test
//    public void test(){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(2);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        List<List<Integer>> rooms =new ArrayList<>();
//        rooms.add(list);
//        rooms.add(list1);
//        rooms.add(list2);
//        canVisitAllRooms(rooms);
//    }
    boolean[] vis;
    int num = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
        dfs(rooms,0);
        return num == n;
    }
    public void dfs(List<List<Integer>> roms , int t){
        vis[t] = true;
        num++;
        for (Integer nu : roms.get(t)){
            if (!vis[nu]){
                dfs(roms,nu);
            }

        }
    }

}
