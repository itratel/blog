package com.itratel.servlet;

import com.itratel.model.Article;
import com.itratel.service.IArticleService;
import com.itratel.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PosteditServlet")
public class PosteditServlet extends HttpServlet {
    IArticleService articleService;
    Article article;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        articleService = new ArticleServiceImpl();
        String action = request.getParameter("action");
        int id=0;
        if (action.equals("delete")) {
            if (articleService.deleteArticle(Integer.parseInt(request.getParameter("id")))) {
                response.getWriter().write("删除成功");
            }
        }
        else {
            article = new Article();
            article.setTitle(request.getParameter("title"));
            article.setMdContent(request.getParameter("test-editormd-markdown-doc"));
            article.setHtmlContent(request.getParameter("text"));
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String hour = request.getParameter("hour");
            String minute = request.getParameter("minute");
            String date = year + "-" + month + "-" + day + " " + hour + ":" + minute;
            if(request.getParameter("id")!=null) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            if (action.equals("add")) {
                if (articleService.addArticle(article) == true) {
                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                }
            } else if (action.equals("update")) {
                if (articleService.updateArticle(article, id) == true) {
                    request.getRequestDispatcher(request.getContextPath() + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}