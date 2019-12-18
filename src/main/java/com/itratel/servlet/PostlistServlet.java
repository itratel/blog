package com.itratel.servlet;

import com.itratel.model.Article;
import com.itratel.model.PageInfo;
import com.itratel.service.IArticleService;
import com.itratel.service.impl.ArticleServiceImpl;
import com.itratel.util.StrUtil;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

import static com.itratel.constant.Constants.*;

/**
 * <p>文章控制层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class PostlistServlet extends HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding(UTF8);
        response.setCharacterEncoding(UTF8);
        IArticleService articleService = new ArticleServiceImpl();
        // 接收request里的参数
        String role = request.getParameter(ROLE);
        String strPageNum = request.getParameter(PAGE_NUM);
        String strPageSize = request.getParameter(PAGE_SIZE);
        //默认值
        int pageNum = StrUtil.isEmpty(strPageNum) ? 1 : Integer.parseInt(strPageNum);
        int pageSize = StrUtil.isEmpty(strPageSize) ? 10 : Integer.parseInt(strPageSize);
        //调用service 获取查询结果
        PageInfo<Article> result = articleService.listArticle(pageNum, pageSize);
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
