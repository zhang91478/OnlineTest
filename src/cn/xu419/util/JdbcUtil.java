package cn.xu419.util;

import java.sql.*;

public final class JdbcUtil {
    private static Connection conn;

    //不允许被创建
    private JdbcUtil() {
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConn() {
        try {
            String url = "jdbc:mysql://localhost:3306/zsb?characterEncoding=utf8&useSSL=true";
            String user = "JavaWeb";
            String password = "q1w2e3r4";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("cn.xu419.conn:连接失败");
        }
        return conn;
    }

    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

