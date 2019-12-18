package com.itratel.dao;

import com.itratel.model.User;
import com.itratel.util.JdbcUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>文章数据访问层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class UserDao {

    /***
     * 根据用户名和密码查询用户名称和密码
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    public boolean verifyUser(String username, String password) {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            String sql = "select * from user where username = ? and password = ?";
            Object[] params = new Object[]{username, password};
            User user = runner.query(conn, sql, new BeanHandler<>(User.class), params);
            return user != null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
    }

    /***
     * 获取当前用户
     * @return User
     */
    public User getUser() {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            String sql = "select * from user where username = ?";
            return runner.query(conn, sql, new BeanHandler<>(User.class), "殷豪");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return null;
    }
}
