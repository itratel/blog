package com.yinhao.dao;

import com.yinhao.model.Message;
import com.yinhao.model.PageInfo;

/**
 * <p>留言数据访问层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class MessageDao {

    /**
     * 根据查询条件，查询文章分页信息
     *
     * @param searchModel 封装查询条件
     * @param pageNum     查询第几页数据
     * @param pageSize    每页显示多少条记录
     * @return 查询结果
     */
    public PageInfo<Message> findMessage(Message searchModel, int pageNum, int pageSize) {
        return new PageInfo<>();
    }

    /**
     * 添加新文章
     *
     * @param message 文章对象
     * @return 插入结果
     */
    public boolean addMessage(Message message) {
        return false;
    }

    /**
     * 修改文章
     *
     * @param message 文章对象
     * @param message 文章
     * @return 更新结果
     */
    public boolean updateMessage(Message message, int id) {
        return false;
    }

    /**
     * 删除文章
     *
     * @param id 文章id
     * @return 删除结果
     */
    public boolean deleteMessage(int id) {
        return false;
    }
}
