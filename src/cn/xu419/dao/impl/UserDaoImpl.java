package cn.xu419.dao.impl;

import cn.xu419.dao.UserDao;
import cn.xu419.domain.User;
import cn.xu419.util.Encryption;
import cn.xu419.util.JdbcUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user, String password) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "INSERT INTO t_user(account,name,email,age,sex,password)VALUES(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,user.getAccount());
            pst.setString(2,user.getName());
            pst.setString(3,user.getEmail());
            pst.setInt(4,user.getAge());
            pst.setString(5,user.getSex());
            pst.setString(6,Encryption.EncoderByMd5(password));
            if(pst.execute()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(null,pst,conn);
        }
        return result;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_user";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setAccount(rs.getString("account"));
                user.setSex(rs.getString("sex"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(rs,pst,conn);
        }
        return users;
    }

    @Override
    public boolean delUserByAccount(String account) {

        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "DELETE FROM t_user WHERE account = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,account);

            System.out.println(pst.toString());

            if(pst.execute()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(null,pst,conn);
        }
        return result;
    }

    @Override
    public User getUser(String account, String password) {
        User user = new User();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_user WHERE account = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,account);
            rs = pst.executeQuery();
            if(rs.next()&&Encryption.checkMd5Password(password,rs.getString("password"))){
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setAccount(account);
                user.setSex(rs.getString("sex"));
            }
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(rs,pst,conn);
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "UPDATE t_user SET " +
                    "name = ?," +
                    "email = ?," +
                    "age =?," +
                    "sex =?" +
                    " WHERE account = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(5,user.getAccount());
            pst.setString(1,user.getName());
            pst.setString(2,user.getEmail());
            pst.setInt(3,user.getAge());
            pst.setString(4,user.getSex());

            System.out.println(pst.toString());
            if(pst.execute()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(null,pst,conn);
        }
        return result;
    }

    @Override
    public boolean updatePassword(String account, String oldPassword, String newPassword) {
        return false;
    }
}
