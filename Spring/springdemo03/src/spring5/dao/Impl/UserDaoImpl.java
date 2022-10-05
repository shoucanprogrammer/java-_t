package spring5.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring5.dao.UserDao;
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add...");
    }
}
