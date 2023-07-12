package s118_generate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        //初始化
        for (int i = 1; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++){
                if (j==0||j==i-1||i<3){
                    list.add(1);
                }else {
                    List<Integer> list1 = lists.get(i - 2);
                    list.add(list1.get(j-1)+list1.get(j));
                }
            }
            lists.add(list);
        }
        //动态规划赋值
    return lists;

    }
}
