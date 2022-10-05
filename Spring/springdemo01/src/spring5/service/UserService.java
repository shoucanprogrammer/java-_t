package spring5.service;

import spring5.dao.UserDao;

public class UserService {
    //创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void add(){
        System.out.println("service add....");
    }
    public void dao(){
        userDao.update();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
