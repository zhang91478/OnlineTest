package cn.xu419.services;

import cn.xu419.dao.DaoFactory;
import cn.xu419.dao.UserDao;
import cn.xu419.domain.User;

public class UserService {

    private UserDao userDao = DaoFactory.createUserDao();

    public UserService() {
    }

    public boolean addUser(User user, String password){
        boolean result = false;
        if(userDao.addUser(user,password)){
            result = true;
        }
        return result;
    }

    public User loginUser(String account,String password){
        return userDao.getUser(account,password);
    }


}
