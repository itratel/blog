package com.itratel.dao;

import com.itratel.util.JdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {

    public boolean verifyUser(String username, String password){
        JdbcUtil jdbcUtil = new JdbcUtil();
        jdbcUtil.getConnection(); // 获取数据库链接
        StringBuilder sql = new StringBuilder("select * from user where 1=1");
        List<Object> paramList = new ArrayList<>();
        paramList.add(username);
        sql.append(" and username = ?");
        paramList.add(password);
        sql.append(" and password = ?");
        List<Map<String, Object>> result;
        try {
            result = jdbcUtil.findResult(sql.toString(), paramList);
            if (result.size() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
