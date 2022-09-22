package com.atguigu.fruit.service.impl;

import com.atguigu.fruit.service.FruitService;
import com.atguigu.fruit.dao.FruitDAO;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public class FruitServceimpl implements FruitService {
    private FruitDAO fruitDAO = null;
    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNO) {
        return  fruitDAO.getFruitListByPage(keyword,pageNO);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer id) {
        return fruitDAO.getFruitByFid(id);
    }

    @Override
    public void delFruitByFid(Integer fid) {
        fruitDAO.delFruitByFid(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int count = fruitDAO.getFruitCount(keyword);
        int pageCount = (count+5-1)/5;
        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
