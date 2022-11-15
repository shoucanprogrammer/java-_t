package com.example.msdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.msdemo.entity.User;
import com.example.msdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MsdemoApplicationTests {
    //查询user表中得数据
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Helennn");
        user.setAge(18);
        user.setEmail("55317332@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);


    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1588085800366534658L);
        user.setName("tlllL");
        user.setAge(20);
        userMapper.updateById(user);
    }
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(1588085800366534658L);
        user.setAge(20);
        userMapper.updateById(user);
    }

    @Test
    public void testSeletDemo1(){

        Collection<Long> collection = new ArrayList<>();
        collection.add(1L);
        collection.add(2L);
        List<User> users = userMapper.selectBatchIds(collection);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String,Object> map= new HashMap<>();
        map.put("name","Jone");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testPage(){
        //1创建page对象
        Page<User> page= new Page<>(1,3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);
        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数

    }
    //删除操作 物理删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1588127465701691394L);
    }
    //删除操作 逻辑删除删除



    //mp实现复杂查询操作
    @Test
    public void testSelectQuery(){
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过QueryWrapper设置条件
        //ge，gt，le，lt
        //查询age>=30的person
        wrapper.ge("age",20);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
        //eq，ne
        //between
        //like
        //orderByDesc
        //last
        //指定要查询的列
    }


}
