package mybatis.test;

import mybatis.mapper.DeptMapper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;


public class ResultMapTest {
    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpIdStepOne(1);
        System.out.println(emp.getEmpName());
    }
    @Test
    public void testGetDeptAndEmpByDepId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper deptmapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptmapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper deptmapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptmapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }

}
