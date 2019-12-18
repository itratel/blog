package com.itratel.servlet;

import com.itratel.model.Article;
import com.itratel.model.PageInfo;
import com.itratel.service.IArticleService;
import com.itratel.service.impl.ArticleServiceImpl;
import com.itratel.util.StrUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

import static com.itratel.constant.Constants.*;

/**
 * <p>转发控制层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "dispatcher", urlPatterns = {"/servlet/dispatcher"})
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding(UTF8);
        response.setCharacterEncoding(UTF8);
        // 接收request里的参数
        String role = request.getParameter(ROLE);

        switch (role) {
            case "0":
                request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
                break;
            case "1":
                request.getRequestDispatcher(request.getContextPath() + "/admin/query.jsp").forward(request, response);
                break;
            case "2":
                request.getRequestDispatcher(request.getContextPath() + "/article.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
}
