package mybatis.test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        Emp emp = mapper.selectByPrimaryKey(1);
////        System.out.println(emp);
//        EmpExample example = new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("张三").andEmpIdEqualTo(1);
//        example.or().andEmpNameEqualTo("李四");
//        List<Emp> list = mapper.selectByExample(example);
//        list.forEach(System.out::println);
        Emp emp = new Emp(1,"小黑",null,"女");
        mapper.updateByPrimaryKey(emp);
    }
}
