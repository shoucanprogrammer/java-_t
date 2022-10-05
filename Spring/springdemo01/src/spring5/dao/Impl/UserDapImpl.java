package spring5.dao.Impl;

import spring5.dao.UserDao;

public class UserDapImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("dao update...");
    }
}
