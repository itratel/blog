package com.itratel.service;

import com.itratel.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean verifyUser(String username, String password) {
        boolean result = userDao.verifyUser(username, password);
        return result;
    }
}
