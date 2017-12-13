package cn.xu419.services;

import cn.xu419.dao.AdminDao;
import cn.xu419.dao.DaoFactory;
import cn.xu419.domain.Admin;

public class AdminService {
    private AdminDao adminDao = DaoFactory.createAdminDao();
    public Admin loginAdmin(String account, String password){
        return adminDao.getAdmin(account,password);
    }

}
