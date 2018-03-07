package com.dongyp.demo.utils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/3/7
 */
public class JDBCPool implements DataSource {

    //由于要频繁读写List集合，所以这里使用LinkedList存储数据库连接比较合适
    private static LinkedList<Connection> connections = new LinkedList<>();

    static{
        try {
            InputStream in = JDBCPool.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            int jdbcPoolInitSize =Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));

            Class.forName(driver);

            for (int i = 0; i < jdbcPoolInitSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("获取到了链接" + conn);
                connections.add(conn);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
            //如果数据库连接池中的连接对象的个数大于0
        if (connections.size()>0) {
            //从listConnections集合中获取一个数据库连接
            final Connection conn = connections.removeFirst();
            System.out.println("listConnections数据库连接池大小是" + connections.size());

            //返回Connection对象的代理对象
            return (Connection) Proxy.newProxyInstance(JDBCPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(!method.getName().equals("close")){
                        return method.invoke(conn, args);
                    }else{
                        //如果调用的是Connection对象的close方法，就把conn还给数据库连接池
                        connections.add(conn);
                        System.out.println(conn + "被还给listConnections数据库连接池了！！");
                        System.out.println("listConnections数据库连接池大小为" + connections.size());
                        return null;
                    }
                }
            });
        } else {
            throw new RuntimeException("对不起，数据库忙");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
