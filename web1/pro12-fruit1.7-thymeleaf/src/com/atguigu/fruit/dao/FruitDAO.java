package com.atguigu.fruit.dao;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();

    //获取指定也马上的库列表信,每页显示5条
    List<Fruit> getFruitListByPage(String keyword,Integer pageNo);

    //根据fid获取特定得水果库存信息
    Fruit getFruitByFid(Integer fid);

    //修改指定得库存记录
    void updataFruit(Fruit fruit);
    void delFruitByFid(Integer fid);
    void addFruit(Fruit fruit);

    //查询库存总记录条数
    int getFruitCount(String keyword);
}
