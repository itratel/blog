package com.itratel.servlet;

import com.itratel.model.Article;
import com.itratel.model.PageInfo;
import com.itratel.service.IArticleService;
import com.itratel.service.impl.ArticleServiceImpl;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class PostlistServlet extends HttpServlet {

    IArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //默认值
        int pageNum = 1;
        int pageSize = 10;
        // 接收request里的参数
        String role = request.getParameter("role");
        // 组装查询条件
        Article searchModel = new Article();
        if (request.getParameter("id") != null) {
            searchModel.setId(Integer.parseInt(request.getParameter("id")));
        }
        if (request.getParameter("pageNum") != null) {
            ////显示第几页数据
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        if (request.getParameter("pageSize") != null) {
            // 每页显示多少条记录
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }
        //调用service 获取查询结果
        PageInfo<Article> result = articleService.findArticle(pageNum, pageSize);
        // 返回结果到页面
        request.setAttribute("result", result);
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
            case "3":
                request.getRequestDispatcher(request.getContextPath() + "/admin/edit.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
}
