package com.yinhao.dao;

import com.yinhao.model.Article;
import com.yinhao.model.PageInfo;
import com.yinhao.util.JdbcUtil;
import com.yinhao.util.OptionalUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>文章数据访问层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class ArticleDao {

    /***
     * 查询前三个文章
     * @return List<Article>
     */
    public List<Article> listTop3Article() {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select id, title, md_content as mdContent, html_content as htmlContent, date from article order by date desc limit ?";
        QueryRunner runner = new QueryRunner();
        try {
            List<Article> top3List = runner.query(conn, sql, new BeanListHandler<>(Article.class), 3);
            return OptionalUtil.listOption(top3List);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return null;
    }

    /**
     * 根据查询条件，查询文章分页信息
     * @param pageNum  查询第几页数据
     * @param pageSize 每页显示多少条记录
     * @return 查询结果
     */
    public PageInfo<Article> listArticle(int pageNum, int pageSize) {
        PageInfo<Article> pageInfo;
        // 存放查询参数
        StringBuilder sql = new StringBuilder("select * from article");
        String countSql = "select count(id) as count from article";
        // 起始索引
        int fromIndex = pageSize * (pageNum - 1);
        // 使用limit关键字，实现分页
        sql.append(" order by date desc limit ").append(fromIndex).append(", ").append(pageSize);
        // 存放所有查询出的文章对象
        List<Article> list;
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            // 获取总记录数
            long total = runner.query(conn, countSql, new ScalarHandler<>());
            // 获取查询的文章记录
            list = runner.query(conn, sql.toString(), new BeanListHandler<>(Article.class));
            long div = total / pageSize;
            //获取总页数
            long totalPage = total % pageSize == 0 ? div : div + 1;
            // 组装pager对象
            pageInfo = new PageInfo<Article>().setPageSize(pageSize)
                    .setCurPage(pageNum).setTotal(total)
                    .setTotalPage(totalPage).setDataList(list);
        } catch (SQLException e) {
            throw new RuntimeException("查询所有数据异常！", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return pageInfo;
    }

    /***
     * 获取一个文章
     * @param id id
     * @return Article
     */
    public Article getOneArticle(int id) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select id, title, md_content as mdContent, html_content as htmlContent, date from article where id = ?";
        QueryRunner runner = new QueryRunner();
        try {
            return runner.query(conn, sql, new BeanHandler<>(Article.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return null;
    }

    /**
     * 添加新文章
     *
     * @param article 文章对象
     * @return 插入结果
     */
    public boolean addArticle(Article article) {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        boolean result = false;
        String sql = "insert into article(title, md_content, html_content) values(?, ?, ?)";
        try {
            runner.insert(conn, sql, new BeanHandler<>(Article.class), Article.getParams(article));
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }

    /**
     * 修改文章
     *
     * @param article 文章对象
     * @param id 编号
     * @return 更新结果
     */
    public boolean updateArticle(Article article, int id) {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        boolean result = false;
        String sql = "update article set title = ?, md_content = ?, html_content = ? where id = ?";
        Object[] params = new Object[]{article.getTitle(), article.getMdContent(), article.getHtmlContent(), id};
        try {
            runner.update(conn, sql, params);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }

    /**
     * 删除文章
     *
     * @param id 文章id
     * @return 删除结果
     */
    public boolean deleteArticle(int id) {
        Connection conn = JdbcUtil.getConnection();
        boolean result = false;
        String sql = "delete from article where id = ?";
        QueryRunner runner = new QueryRunner();
        try {
            runner.execute(conn, sql, id);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
}
