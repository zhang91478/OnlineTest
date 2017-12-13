package cn.xu419.dao;

import cn.xu419.dao.impl.AdminDaoImpl;
import cn.xu419.dao.impl.RadioDaoImpl;
import cn.xu419.dao.impl.UserDaoImpl;

public class DaoFactory {

    public static UserDao createUserDao(){
        return new UserDaoImpl();
    }

    public static RadioDao createRadioDao(){
        return new RadioDaoImpl();
    }

    public static AdminDao createAdminDao(){
        return new AdminDaoImpl();
    }
}
