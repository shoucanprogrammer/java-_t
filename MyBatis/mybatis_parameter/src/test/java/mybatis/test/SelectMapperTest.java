package mybatis.test;

import mybatis.mapper.SelectMapper;
import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User userById = selectMapper.getUserById(1);
        System.out.println(userById);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = selectMapper.getAllUser();
        allUser.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = selectMapper.getCount();
        System.out.println(count);
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> allUser = selectMapper.getUserByIdToMap(1);
        System.out.println();
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> allUserToMap = selectMapper.getAllUserToMap();
        System.out.println();
    }
    @Test
    public void testGetAllUserToMap1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> allUserToMap1 = selectMapper.getAllUserToMap1();
        System.out.println(allUserToMap1);
    }
}
