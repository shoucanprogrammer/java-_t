package mianshi04_12;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution1 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        return  midSearch(root,sum,map,0);
    }

    public int midSearch(TreeNode root,int sum,HashMap<Integer,Integer> map,int cur){
        if (root == null){
            return 0;
        }
        cur += root.val;
        Integer orDefault = map.getOrDefault(cur - sum, 0);
        map.put((cur ),map.getOrDefault((cur ),0) + 1 );
        orDefault += midSearch(root.left, sum, map, cur);
        orDefault += midSearch(root.right, sum, map, cur);
        map.put( (cur ),map.getOrDefault( (cur),0) - 1 );
        return orDefault;
    }
}
