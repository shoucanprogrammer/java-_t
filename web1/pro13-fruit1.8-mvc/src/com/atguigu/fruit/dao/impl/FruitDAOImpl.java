package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }

    @Override
    public List<Fruit> getFruitListByPage(String keyword,Integer pageNo) {
//        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?,5","%"+keyword+"%","%"+keyword+"%",(pageNo-1)*5);
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ? , 5" ,"%"+keyword+"%","%"+keyword+"%", (pageNo-1)*5);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return super.load("select * from t_fruit where fid = ?",fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
//        String sql = "updata t_fruit set fname = ? , price = ? , fcount = ? , remark = ? where fid = ?";
//        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());
        String sql = "update t_fruit set fname = ? , price = ? , fcount = ? , remark = ? where fid = ? " ;
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());
    }

    @Override
    public void delFruitByFid(Integer fid) {
        String sql = "delete from t_fruit where fid = ?";
        super.executeUpdate(sql,fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
//        String sql = "insert into t_fruit values(0,?,?,?,?)";
//        String sql = "insert into t_fruit values(0,?,?,?,?)";
//        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
        String sql = "INSERT INTO t_fruit ( fname, price,fcount,remark ) VALUES ( ?, ?,?,? )";
        super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
    }

    @Override
    public int getFruitCount(String keyword) {
//        return ((Long)super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?" , "%"+keyword+"%","%"+keyword+"%")[0]).intValue();
        Object[] objects = super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?" , "%"+keyword+"%","%"+keyword+"%");
        Object object = objects[0];
        String s = String.valueOf(object);
        return Integer.parseInt(String.valueOf(s));
    }


}
