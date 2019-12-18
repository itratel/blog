package com.itratel.servlet;

import com.itratel.model.Article;
import com.itratel.service.IArticleService;
import com.itratel.service.impl.ArticleServiceImpl;
import com.itratel.util.StrUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.itratel.constant.Constants.*;

/**
 * <p>文章控制层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "article")
public class ArticleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String contextPath = request.getContextPath();
        //因为servlet是单例的，因此为了线程安全，禁止初始化实例变量
        IArticleService articleService = new ArticleServiceImpl();
        String action = request.getParameter(ACTION);
        String strId = request.getParameter(ID);
        String title = request.getParameter(TITLE);
        String htmlContent = request.getParameter(HTML_CONTENT);
        String mdContent = request.getParameter(MD_CONTENT);
        int id = 0;
        if (action.equals(DELETE)) {
            if (articleService.deleteArticle(Integer.parseInt(strId))) {
                response.getWriter().write("删除成功");
            }
        } else {
            Article article = new Article();
            article.setTitle(title);
            article.setMdContent(mdContent);
            article.setHtmlContent(htmlContent);
            if (StrUtil.isNotEmpty(strId)) {
                id = Integer.parseInt(strId);
            }
            if (action.equals(ADD)) {
                if (articleService.addArticle(article)) {
                    request.getRequestDispatcher(contextPath + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(contextPath + "/error.jsp").forward(request, response);
                }
            } else if (action.equals(UPDATE)) {
                if (articleService.updateArticle(article, id)) {
                    request.getRequestDispatcher(contextPath + "/success.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher(contextPath + "/error.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}