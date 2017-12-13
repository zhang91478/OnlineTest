package cn.xu419.dao.impl;

import cn.xu419.dao.RadioDao;
import cn.xu419.domain.Radio;
import cn.xu419.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadioDaoImpl implements RadioDao{
    private final static int[] [] RANDOM  ={
            {3,4,5,6},{3,5,4,6},{3,6,4,5},{3,6,5,4},
            {4,3,5,6},{4,5,3,6},{4,5,3,5},{4,6,5,3},
            {5,3,4,6},{5,4,3,6},{5,6,3,4},{5,6,4,3},
            {6,3,4,5},{6,4,3,5},{6,5,3,4},{6,5,4,3}};


    @Override
    public boolean addRadio(Radio radio) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "INSERT INTO t_radio" +
                    "(stem,optionOne,optionTwo,optionThree,optionFour,score,course) " +
                    "VALUES(?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,radio.getStem());
            pst.setString(2,radio.getOptionOne());
            pst.setString(3,radio.getOptionTwo());
            pst.setString(4,radio.getOptionThree());
            pst.setString(5,radio.getOptionFour());
            pst.setInt(6,radio.getScore());
            pst.setString(7,radio.getCourse());
            if(pst.execute()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.free(null,pst,conn);
        }
        return result;
    }

    @Override
    public boolean delRadioByNum(int num) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "DELETE FROM t_radio WHERE num = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
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
    public List<Radio> findAllRadioByCourse(String course) {
        List<Radio> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_radio WHERE course = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,course);
            rs = pst.executeQuery();
            while (rs.next()){
                Radio radio = new Radio();
                Random rd = new Random();
                int i = rd.nextInt(16);
                radio.setNum(rs.getInt("num"));
                radio.setScore(rs.getInt("score"));
                radio.setCourse(rs.getString("course"));
                radio.setStem(rs.getString("stem"));
                radio.setOptionOne(rs.getString(RANDOM[i][0]));
                radio.setOptionTwo(rs.getString(RANDOM[i][1]));
                radio.setOptionThree(rs.getString(RANDOM[i][2]));
                radio.setOptionFour(rs.getString(RANDOM[i][3]));
                list.add(radio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,pst,conn);
        }
        return list;
    }

    @Override
    public List<Radio> getAllRadio() {
        List<Radio> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_radio";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Radio radio = new Radio();
                Random rd = new Random();
                int i = rd.nextInt(16);
                radio.setNum(rs.getInt("num"));
                radio.setScore(rs.getInt("score"));
                radio.setCourse(rs.getString("course"));
                radio.setStem(rs.getString("stem"));
                radio.setOptionOne(rs.getString(RANDOM[i][0]));
                radio.setOptionTwo(rs.getString(RANDOM[i][1]));
                radio.setOptionThree(rs.getString(RANDOM[i][2]));
                radio.setOptionFour(rs.getString(RANDOM[i][3]));
                list.add(radio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,pst,conn);
        }
        return list;
    }

    @Override
    public boolean updateRadio(Radio radio) {

        boolean result = false;
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "UPDATE t_radio " +
                    "SET stem=?" +
                    ",optionOne =?" +
                    ",optionTwo=?" +
                    ",optionThree=?" +
                    ",optionFour=?" +
                    ",score=?" +
                    ",course=?" +
                    " WHERE num =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,radio.getStem());
            pst.setString(2,radio.getOptionOne());
            pst.setString(3,radio.getOptionTwo());
            pst.setString(4,radio.getOptionThree());
            pst.setString(5,radio.getOptionFour());
            pst.setInt(6,radio.getScore());
            pst.setString(7,radio.getCourse());
            pst.setInt(8,radio.getNum());

            System.out.println(pst.toString());

            if(pst.execute()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.free(null,pst,conn);
        }
        return result;
    }

    @Override
    public Radio findRadioByNum(String num) {
        Radio radio = new Radio();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_radio WHERE num = "+num;

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()) {
                radio.setNum(rs.getInt("num"));
                radio.setScore(rs.getInt("score"));
                radio.setCourse(rs.getString("course"));
                radio.setStem(rs.getString("stem"));
                radio.setOptionOne(rs.getString(3));
                radio.setOptionTwo(rs.getString(4));
                radio.setOptionThree(rs.getString(5));
                radio.setOptionFour(rs.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,st,conn);
        }
        return radio;
    }

    @Override
    public List<Radio> findAllRadioBySomething(String option) {
        List<Radio> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConn();
            String sql = "SELECT * FROM t_radio WHERE stem LIKE ?" +
                    " OR optionOne LIKE ? OR optionTwo LIKE ? OR optionThree LIKE ? OR optionFour LIKE ?" +
                    " OR course  LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,"%"+option+"%");
            pst.setString(2,"%"+option+"%");
            pst.setString(3,"%"+option+"%");
            pst.setString(4,"%"+option+"%");
            pst.setString(5,"%"+option+"%");
            pst.setString(6,"%"+option+"%");

            System.out.println(pst.toString());
            rs = pst.executeQuery();

            while (rs.next()){
                Radio radio = new Radio();
                radio.setNum(rs.getInt("num"));
                radio.setScore(rs.getInt("score"));
                radio.setCourse(rs.getString("course"));
                radio.setStem(rs.getString("stem"));
                radio.setOptionOne(rs.getString("optionONe"));
                radio.setOptionTwo(rs.getString("optionTwo"));
                radio.setOptionThree(rs.getString("optionThree"));
                radio.setOptionFour(rs.getString("optionFour"));
                list.add(radio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,pst,conn);
        }
        return list;
    }
}
