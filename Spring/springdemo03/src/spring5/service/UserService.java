package spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring5.dao.UserDao;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void add(){
        System.out.println("service add");
        userDao.add();
    }
}
