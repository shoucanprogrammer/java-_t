package s638_shoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {

    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        //过来掉没用的礼包
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special){
            int sum = 0;
           for (int i = 0; i < price.size(); i++){
               sum += sp.get(i)*price.get(i);
           }
            if ( sum > sp.get(price.size())) {
                filterSpecial.add(sp);
            }
        }


        return dfs(price, special, needs, filterSpecial, price.size());

    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds,
                    List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)){
            //计算不需要礼包的费用
            int minPrice = 0;
            for ( int i = 0; i < n; i++){
                minPrice += curNeeds.get(i) * price.get(i);
            }
            //计算大礼包
            for (List<Integer> sp : special){
                List<Integer> nxtNeeds = new ArrayList<Integer>();
                for (int i = 0; i < n; i++){
                    if (sp.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - sp.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, special, nxtNeeds, filterSpecial, n) + sp.get(n));
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }
}
