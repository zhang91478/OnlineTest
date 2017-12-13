package cn.xu419.dao;

import cn.xu419.domain.Admin;

public interface AdminDao{
    public boolean addAdmin(Admin admin, String password);

    public boolean delAdminByAccount(String account);

    public Admin getAdmin(String account,String password);

    public boolean updateAdmin(Admin admin);

    public boolean updatePassword(String account,String oldPassword,String newPassword);
}
