package com.itratel.service;

import com.itratel.model.User;

/**
 * <p>文章业务层接口</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public interface IUserService {

    /***
     * 根据用户名和密码查询用户名称和密码
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    boolean verifyUser(String username, String password);

    /***
     * 获取当前用户
     * @return User
     */
    User getUser();
}
