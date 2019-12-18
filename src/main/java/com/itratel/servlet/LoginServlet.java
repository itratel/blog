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

import static com.itratel.constant.Constants.*;

/**
 * <p>登录接口</p>
 *
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "login", urlPatterns = {"/servlet/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(UTF8);
        response.setCharacterEncoding(UTF8);
        IUserService userService = new UserServiceImpl();
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String re = request.getParameter(VERIFY_CODE);
        String answer = (String) request.getSession().getAttribute(VERIFY_CODE);
        if ((userService.verifyUser(username, password)) && (re.equals(answer))) {
            HttpSession session = request.getSession();
            session.setAttribute(USERNAME, username);
            session.setMaxInactiveInterval(3 * 60);
            response.sendRedirect("article?" + ACTION + "=" + GET_PAGE);
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
        }
    }
}
