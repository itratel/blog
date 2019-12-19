package com.yinhao.service.impl;

import com.yinhao.dao.MessageDao;
import com.yinhao.model.Message;
import com.yinhao.model.PageInfo;
import com.yinhao.service.IMessageService;

/**
 * @author whd.java@gmail.com
 * @date 2019/12/19 23:19
 * @apiNote Describe the function of this class in one sentence
 */
public class MessageServiceImpl implements IMessageService {

    private MessageDao messageDao;

    public MessageServiceImpl() {
        messageDao = new MessageDao();
    }

    /***
     * 分页查询评论
     * @param articleId 文章id
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return PageInfo<Message>
     */
    @Override
    public PageInfo<Message> listMessage(int articleId, int pageNum, int pageSize) {
        return messageDao.listMessage(articleId, pageNum, pageSize);
    }

    /***
     * 插入评论
     * @param message 评论
     * @return boolean
     */
    @Override
    public boolean addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    /**
     * 删除评论
     * @param id 评论id
     * @return 删除结果
     */
    @Override
    public boolean deleteMessage(int id) {
        return messageDao.deleteMessage(id);
    }
}
