package s1079_numTilePossibilities;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        numTilePossibilities("AAB");
    }
    private Set<List> set = new HashSet<>();
    private List<Character> list = new LinkedList<>();
    private boolean[] used;
    public int numTilePossibilities(String tiles) {
        used = new boolean[tiles.length()];
        traceBack(tiles,used,0);
        return set.size();
    }
    public void traceBack(String string,boolean[] used,int usedNum){
        if (usedNum == used.length){
            return;
        }
        for (int i = 0; i < string.length(); i++){
            if (used[i] == false){
                list.add(string.charAt(i));

                if (set.contains(list)){
                    list.remove(list.size()-1);
                    continue;
                }else {
                    set.add(new ArrayList(list));
                    used[i] = true;
                    traceBack(string,used,usedNum+1);
                    used[i] = false;
                    list.remove(list.size()-1);
                }
            }else {
                continue;
            }

        }
    }
}
