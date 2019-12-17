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

    public User getUser() {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            String sql = "select * from user where username = 殷豪";
            return runner.query(conn, sql, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return null;
    }
}
