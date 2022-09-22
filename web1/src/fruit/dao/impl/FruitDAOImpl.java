package fruit.dao.impl;

import fruit.dao.FruitDAO;
import fruit.dao.base.BaseDAO;
import fruit.pojo.Fruit;

import org.junit.Test;
import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
//    @Test public void test2(){
//
//        boolean b = addFruit(new Fruit(0, "huanggua", 4, 200, "太贵了"));
//        System.out.println(b);
//    }
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        String sql = "insert into t_fruit values(0,?,?,?,?)";
        int count = super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark()) ;
        //insert语句返回的是自增列的值，而不是影响行数
        //System.out.println(count);
        return count>0;
    }

    @Override
    public boolean updateFruit(Fruit fruit) {
        String sql = "update t_fruit set fcount = ? where fid = ? " ;
        return super.executeUpdate(sql,fruit.getFcount(),fruit.getFid())>0;
    }

    @Override
    public Fruit getFruitByFname(String fname) {
        return super.load("select * from t_fruit where fname like ? ",fname);
    }

    @Override
    public boolean delFruit(String fname) {
        String sql = "delete from t_fruit where fname like ? " ;
        return super.executeUpdate(sql,fname)>0;
    }
}