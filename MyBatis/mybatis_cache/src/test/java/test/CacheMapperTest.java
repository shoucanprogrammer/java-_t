package test;

import mybatis.mapper.CacheMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {

    @Test
    public void testGetById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        Emp emp2 = mapper.getEmpById(2);
        System.out.println(emp2);
//        mapper.insertEmp(new Emp(null,"小红",25,"男"));
//        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        Emp emp3 = mapper2.getEmpById(1);
//        System.out.println(emp3);
        sqlSession.clearCache();
        Emp emp4 = mapper.getEmpById(1);
        System.out.println(emp4);

    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        mapper1.getEmpById(1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        mapper2.getEmpById(1);


    }

}
