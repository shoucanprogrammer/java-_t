package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /**
     *
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     *
     * @param emp
     */
    void insertEmp(Emp emp);
}
