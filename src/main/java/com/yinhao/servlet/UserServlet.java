package com.yinhao.servlet;

import com.yinhao.model.User;
import com.yinhao.service.IUserService;
import com.yinhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.yinhao.constant.Constants.USER;
import static com.yinhao.constant.Constants.UTF8;

/**
 * <p>用户控制器</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "user", urlPatterns = {"/servlet/user"})
public class UserServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(UTF8);
        response.setCharacterEncoding(UTF8);
        IUserService userService = new UserServiceImpl();
        User user = userService.getUser();
        request.getSession().setAttribute(USER, user);
        request.getRequestDispatcher(request.getContextPath() + "/userInfo.jsp").forward(request, response);
    }

}
