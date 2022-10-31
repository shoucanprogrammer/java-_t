package mybatis.mapper;

import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpIdStepOne(@Param("empId") Integer empId);

    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

}
