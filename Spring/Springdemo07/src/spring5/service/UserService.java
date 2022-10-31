package spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring5.dao.UserDao;

@Service
@Transactional(timeout = -1,propagation =  Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {

    @Autowired
    private UserDao userDao;

    public void accountMoney(){

        userDao.reduceMoney();
        int a = 10/0;
        //mary多100
        userDao.addMoney();


    }
}
