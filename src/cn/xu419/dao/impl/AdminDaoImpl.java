package cn.xu419.dao.impl;

import cn.xu419.dao.AdminDao;
import cn.xu419.domain.Admin;
import cn.xu419.util.Encryption;
import cn.xu419.util.JdbcUtil;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao{
    @Override
    public boolean addAdmin(Admin admin, String password) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "INSERT INTO t_admin(account,name,email,permission,password) VALUES (?,?,?,?,?) ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,admin.getAccount());
            pst.setString(2,admin.getName());
            pst.setString(3,admin.getEmail());
            pst.setInt(4,admin.getPermission());
            pst.setString(5, Encryption.EncoderByMd5(password));
            result = pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(null,pst,conn);
        }
        return result;
    }

    @Override
    public boolean delAdminByAccount(String account) {
        boolean result = false;
        try{
            Connection conn = JdbcUtil.getConn();
            String sql = "DELETE FROM t_admin WHERE account = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,account);
            result =pst.execute();
            JdbcUtil.free(null,pst,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Admin getAdmin(String account, String password) {
        Admin result = new Admin();
        try{
            Connection conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_admin WHERE account = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,account);
            pst.execute();
            ResultSet rs = pst.executeQuery();
            if(rs.next()&&Encryption.checkMd5Password(password,rs.getString("password"))){
                result.setAccount(account);
                result.setEmail(rs.getString("email"));
                result.setName(rs.getString("name"));
                result.setPermission(rs.getInt("permission"));
            }
            JdbcUtil.free(rs,pst,conn);
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public boolean updateAdmin(Admin admin) {
        return false;
    }

    @Override
    public boolean updatePassword(String account, String oldPassword, String newPassword) {
        return false;
    }
}
