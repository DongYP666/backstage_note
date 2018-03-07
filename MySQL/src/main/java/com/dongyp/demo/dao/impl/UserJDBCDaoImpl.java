package com.dongyp.demo.dao.impl;

import com.dongyp.demo.dao.IUserJDBCDao;
import com.dongyp.demo.domain.User;
import com.dongyp.demo.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/6
 */
public class UserJDBCDaoImpl implements IUserJDBCDao{
//    事务
//    conn.setAutoCommit(false);//通知数据库开启事务(start transaction)
//    conn.commit();//SQL执行Update语句成功之后就通知数据库提交事务(commit)
//    conn.rollback(); 捕获到异常之后手动通知数据库执行回滚事务的操作

//    sp = conn.setSavepoint();//设置事务回滚点
//    conn.rollback(sp);//回滚到设置的事务回滚点

    @Override
    public int insert(User user) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int num = 0;

        try {
            //获取一个数据库连接
            conn = JDBCUtils.getConnection();
            //要执行的SQL命令
            String sql = "insert into user(username,password,email,birthday) values(?,?,?,?)";
            //通过conn对象获取负责执行SQL命令的prepareStatement对象
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1,user.getUserName());
            st.setString(2,user.getUserPwd());
            st.setString(3,user.getEmail());
            st.setDate(4,new Date(user.getBirthday().getTime()));
            System.out.println(sql);
            num = st.executeUpdate();
//           获取自增主键
//            rs = st.getGeneratedKeys();
//            if(rs.next()){
//                System.out.println(rs.getInt(1));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,st,rs);
        }
        return num;
    }

    @Override
    public int update(User user) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "update user set username=?,password=?,email=?,birthday=? where id=?;";
            st = conn.prepareStatement(sql);
            st.setString(1,user.getUserName());
            st.setString(2,user.getUserPwd());
            st.setString(3,user.getEmail());
            st.setDate(4,new Date(user.getBirthday().getTime()));
            st.setString(5,user.getId());
            System.out.println(sql);
            num = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,st,rs);
        }
        return num;
    }

    @Override
    public int delete(User user) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from user where id=?;";
            st = conn.prepareStatement(sql);
            st.setString(1,user.getId());
            System.out.println(sql);
            num = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,st,rs);
        }
        return num;
    }

    @Override
    public User findOne(String username) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username=?;";
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            System.out.println(sql);
            rs = st.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setUserPwd(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,st,rs);
        }
        return null;
    }

    @Override
    public List<User> find() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user;";
            st = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = st.executeQuery();
            List<User> users = new ArrayList<>();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setUserPwd(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,st,rs);
        }
        return null;
    }
}
