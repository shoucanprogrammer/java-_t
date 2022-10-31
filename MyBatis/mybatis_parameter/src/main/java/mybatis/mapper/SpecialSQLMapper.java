package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    List<User> getUserByLike(@Param("mohu") String mohu);

    void deleteMoreUser(@Param("ids") String ids);

    List<User> getUserList(@Param("tableName") String tableName);

    void insertUser(User user);
}
