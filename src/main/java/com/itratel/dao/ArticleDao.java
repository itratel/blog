package com.itratel.dao;

import com.itratel.model.Article;
import com.itratel.model.PageInfo;
import com.itratel.util.JdbcUtil;
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
    /**
     * 根据查询条件，查询文章分页信息
     *
     * @param pageNum  查询第几页数据
     * @param pageSize 每页显示多少条记录
     * @return 查询结果
     */
    public PageInfo<Article> findArticle(int pageNum, int pageSize) {
        PageInfo<Article> pageInfo;
        // 存放查询参数
        StringBuilder sql = new StringBuilder("select * from article");
        String countSql = "select count(id) as count from article";
        // 起始索引
        int fromIndex = pageSize * (pageNum - 1);
        // 使用limit关键字，实现分页
        sql.append(" limit ").append(fromIndex).append(", ").append(pageSize);
        // 存放所有查询出的文章对象
        List<Article> list;
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            // 获取总记录数
            long total = runner.query(conn, countSql, new ScalarHandler<>());
            // 获取查询的文章记录
            list = runner.query(conn, sql.toString(), new BeanListHandler<>(Article.class));
            //获取总页数
            long totalPage = total / pageSize;
            if (total % pageSize != 0) {
                totalPage++;
            }
            // 组装pager对象
            pageInfo = new PageInfo<>(pageSize, pageNum, total, totalPage, list);
        } catch (SQLException e) {
            throw new RuntimeException("查询所有数据异常！", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return pageInfo;
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
        String sql = "insert into article(title, md_content, html_content, date) values(?, ?, ?, ?)";
        try {
            Article insert = runner.insert(conn, sql, new BeanHandler<>(Article.class), Article.getParams(article));
            if (insert != null) {
                result = true;
            }
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
        String sql = "update article set title = ?, md_content = ?, html_content = ?, date = ? where id = ?";
        Object[] params = new Object[]{article.getTitle(), article.getMdContent(), article.getHtmlContent(), article.getDate(), id};
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
