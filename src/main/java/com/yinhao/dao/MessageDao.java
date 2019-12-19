package com.yinhao.dao;

import com.yinhao.model.Message;
import com.yinhao.model.Message;
import com.yinhao.model.PageInfo;
import com.yinhao.util.JdbcUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>留言数据访问层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class MessageDao {

    /**
     * 根据查询条件，查询评论分页信息
     * @param articleId   文章id
     * @param pageNum     查询第几页数据
     * @param pageSize    每页显示多少条记录
     * @return 查询结果
     */
    public PageInfo<Message> listMessage(int articleId, int pageNum, int pageSize) {
        PageInfo<Message> pageInfo;
        // 存放查询参数
        StringBuilder sql = new StringBuilder("select id, a_id as aId, content, critics, date from message where a_id = ?");
        String countSql = "select count(id) as count from message where a_id = ?";
        // 起始索引
        int fromIndex = pageSize * (pageNum - 1);
        // 使用limit关键字，实现分页
        sql.append(" order by date desc limit ").append(fromIndex).append(", ").append(pageSize);
        // 存放所有查询出的评论对象
        List<Message> list;
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        try {
            // 获取总记录数
            long total = runner.query(conn, countSql, new ScalarHandler<>(), articleId);
            // 获取查询的评论记录
            list = runner.query(conn, sql.toString(), new BeanListHandler<>(Message.class), articleId);
            //获取总页数
            long totalPage = total / pageSize;
            if (total % pageSize != 0) {
                totalPage++;
            }
            // 组装pager对象
            pageInfo = new PageInfo<>(pageSize, pageNum, total, totalPage, list);
        } catch (SQLException e) {
            throw new RuntimeException("查询所评论数据异常！", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return pageInfo;
    }

    /**
     * 添加新评论
     * @param message 评论对象
     * @return 插入结果
     */
    public boolean addMessage(Message message) {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner runner = new QueryRunner();
        boolean result = false;
        String sql = "insert into message(a_id, content, critics) values(?, ?, ?)";
        try {
            runner.insert(conn, sql, new BeanHandler<>(Message.class), Message.getParams(message));
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }

    /**
     * 删除评论
     * @param id 评论id
     * @return 删除结果
     */
    public boolean deleteMessage(int id) {
        Connection conn = JdbcUtil.getConnection();
        boolean result = false;
        String sql = "delete from message where id = ?";
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
