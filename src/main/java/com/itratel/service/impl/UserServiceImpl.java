package com.itratel.service.impl;

import com.itratel.dao.UserDao;
import com.itratel.model.User;
import com.itratel.service.IUserService;

/**
 * <p>用户业务层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class UserServiceImpl implements IUserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDao();
    }

    /***
     * 根据用户名和密码查询用户名称和密码
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    @Override
    public boolean verifyUser(String username, String password) {
        return userDao.verifyUser(username, password);
    }

    /***
     * 获取当前用户
     * @return User
     */
    @Override
    public User getUser() {
        return userDao.getUser();
    }
}
