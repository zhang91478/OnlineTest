package cn.xu419.dao;

import cn.xu419.domain.User;

import java.util.List;

public interface UserDao {
    public boolean addUser(User user,String password);

    public List<User> getAllUser();

    public boolean delUserByAccount(String account);

    public User getUser(String account,String password);

    public boolean updateUser(User user);

    public boolean updatePassword(String account,String oldPassword,String newPassword);
}
