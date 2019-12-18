package com.itratel.servlet;

import com.itratel.model.Article;
import com.itratel.model.PageInfo;
import com.itratel.service.IArticleService;
import com.itratel.service.impl.ArticleServiceImpl;
import com.itratel.util.StrUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.itratel.constant.Constants.*;

/**
 * <p>文章控制层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
@WebServlet(name = "article", urlPatterns = {"/servlet/article"})
public class ArticleServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //因为servlet是单例的，因此为了线程安全，禁止初始化实例变量
        String action = request.getParameter(ACTION);
        if (StrUtil.isEmpty(action)) {
            action = TOP_THREE;
        }
        switch (action) {
            case GET_PAGE:
                page(request, response);
                break;
            case DELETE:
                delete(request, response);
                break;
            case ADD:
                add(request, response);
                break;
            case UPDATE:
                update(request, response);
                break;
            case GET_ONE:
                getOne(request, response);
                break;
            case TOP_THREE:
                listTop3(request, response);
                break;
            default:
                break;
        }
    }

    /***
     * 查询top3的文章
     * @param request request
     * @param response response
     */
    private void listTop3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IArticleService articleService = new ArticleServiceImpl();
        List<Article> list = articleService.listTop3Article();
        request.setAttribute("list", list);
        request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
    }

    /***
     * 分页查询文章信息
     * @param request request
     * @param response response
     */
    private void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strPageNum = request.getParameter(PAGE_NUM);
        String strPageSize = request.getParameter(PAGE_SIZE);
        //默认值
        int pageNum = StrUtil.isEmpty(strPageNum) ? MIN_PAGE_SIZE : Integer.parseInt(strPageNum);
        int pageSize = StrUtil.isEmpty(strPageSize) ? MAX_PAGE_SIZE : Integer.parseInt(strPageSize);
        IArticleService articleService = new ArticleServiceImpl();
        //调用service 获取查询结果
        PageInfo<Article> result = articleService.listArticle(pageNum, pageSize);
        // 返回结果到页面
        request.setAttribute("result", result);
        request.getRequestDispatcher(request.getContextPath() + "/admin/query.jsp").forward(request, response);
    }

    /***
     * 获取一个文章的基本信息
     * @param request request
     * @param response response
     */
    private void getOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter(ID);
        int id = Integer.parseInt(strId.trim());
        IArticleService articleService = new ArticleServiceImpl();
        Article article = articleService.getOneArticle(id);
        String contextPath = request.getContextPath();
        request.setAttribute("article", article);
        request.getRequestDispatcher(contextPath + "/admin/edit.jsp").forward(request, response);
    }

    /***
     * 删除文章
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IArticleService articleService = new ArticleServiceImpl();
        String strId = request.getParameter(ID);
        int id = Integer.parseInt(strId);
        if (articleService.deleteArticle(id)) {
            response.getWriter().write("删除成功");
        }
    }

    /***
     * 新增文章
     * @param request request
     * @param response response
     * @throws ServletException
     * @throws IOException
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IArticleService articleService = new ArticleServiceImpl();
        Article article = getArticle(request);
        String contextPath = request.getContextPath();
        if (articleService.addArticle(article)) {
            response.sendRedirect("article?" + ACTION + "=" + GET_PAGE);
        } else {
            request.getRequestDispatcher(contextPath + "/error.jsp").forward(request, response);
        }
    }

    /***
     * 修改文章
     * @param request request
     * @param response request
     * @throws ServletException
     * @throws IOException
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IArticleService articleService = new ArticleServiceImpl();
        Article article = getArticle(request);
        String strId = request.getParameter(ID);
        String contextPath = request.getContextPath();
        int id = 0;
        if (StrUtil.isNotEmpty(strId)) {
            id = Integer.parseInt(strId);
        }
        if (articleService.updateArticle(article, id)) {
            response.sendRedirect("article?" + ACTION + "=" + GET_PAGE);
        } else {
            request.getRequestDispatcher(contextPath + "/error.jsp").forward(request, response);
        }
    }


    /***
     * 从参数中获取文章内容
     * @param request request
     * @return Article
     */
    private Article getArticle(HttpServletRequest request) {
        String title = request.getParameter(TITLE);
        String htmlContent = request.getParameter(HTML_CONTENT);
        String mdContent = request.getParameter(MD_CONTENT);
        Article article = new Article();
        article.setTitle(title);
        article.setMdContent(mdContent);
        article.setHtmlContent(htmlContent);
        return article;
    }
}