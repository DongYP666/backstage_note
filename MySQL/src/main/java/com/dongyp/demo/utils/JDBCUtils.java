package com.dongyp.demo.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/5
 */
public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

//    数据库连接池获取连接
//    private static JDBCPool pool = new JDBCPool();
//    public static Connection getConnection() throws SQLException {
//        return pool.getConnection();
//    }

    static {
        try {
            //读取db.properties文件中的数据库连接信息
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);

            //获取数据库连接驱动
            driver = prop.getProperty("driver");
            //获取数据库连接URL地址
            url = prop.getProperty("url");
            //获取数据库连接用户名
            username = prop.getProperty("username");
            //获取数据库连接密码
            password = prop.getProperty("password");

            //加载数据库驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // 获取数据库连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username,password);
    }

    //释放资源
    //要释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                //关闭Connection数据库连接对象
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
