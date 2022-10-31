package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User root = mapper.getUserByUsername("root");
        System.out.println(root);
    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("root", "123");
        System.out.println(user);
    }
    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","root");
        map.put("password","123");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void InsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","root");
        map.put("password","123");
        mapper.insertUser(new User(null,"mary","123",23,"女","123@qq.com"));
    }
    @Test
    public void CheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.checkLoginByParam("mary", "123");
        System.out.println(user);

    }
}
