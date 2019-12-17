package com.itratel.util;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class JdbcUtil {

    /***
     * 数据库的用户名
     */
    private static String USERNAME;
    /***
     * 数据库的密码
     */
    private static String PASSWORD;
    /***
     * 定义数据库的驱动信息
     */
    private static String DRIVER;
    /**
     * 数据库的地址
     */
    private static String URL;

    static {
        try {
            //加载数据库配置信息，并给相关的属性赋值
            loadConfig();
            // 注册驱动
            Class.forName(DRIVER);
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
            USERNAME = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
            DRIVER = prop.getProperty("jdbc.driver");
            URL = prop.getProperty("jdbc.url");
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
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }
}
