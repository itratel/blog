package com.itratel.servlet;

import com.itratel.service.IUserService;
import com.itratel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>登录接口</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private IUserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re = request.getParameter("VerifyCode");
        String answer = (String) request.getSession().getAttribute("VerifyCode");
        if ((userService.verifyUser(username, password)) && (re.equals(answer))) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(3 * 60);
            response.sendRedirect("PostlistServlet?role=1");
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
