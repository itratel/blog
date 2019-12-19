package com.yinhao.util;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * <p>数据库工具</p>
 *
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public final class JdbcUtil {

    /***
     * 数据库的用户名
     */
    private static String username;
    /***
     * 数据库的密码
     */
    private static String password;
    /***
     * 定义数据库的驱动信息
     */
    private static String driver;
    /**
     * 数据库的地址
     */
    private static String url;

    static {
        try {
            //加载数据库配置信息，并给相关的属性赋值
            loadConfig();
            // 注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 加载数据库配置信息，并给相关的属性赋值
     */
    private static void loadConfig() {
        try {
            InputStream inStream = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
            Properties prop = new Properties();
            prop.load(inStream);
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            driver = prop.getProperty("jdbc.driver");
            url = prop.getProperty("jdbc.url");
        } catch (Exception e) {
            throw new RuntimeException("读取数据库配置文件异常！", e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        //数据库的链接
        Connection connection;
        try {
            // 获取连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }
}
