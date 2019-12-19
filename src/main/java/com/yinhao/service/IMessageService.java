package com.yinhao.service;

import com.yinhao.model.Message;
import com.yinhao.model.PageInfo;

import java.util.List;

/**
 * <p>评论业务层接口</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public interface IMessageService {


    /***
     * 分页查询评论
     * @param articleId 文章id
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return PageInfo<Message>
     */
    PageInfo<Message> listMessage(int articleId, int pageNum, int pageSize);

    /***
     * 插入评论
     * @param message 评论
     * @return boolean
     */
    boolean addMessage(Message message);

    /**
     * 删除评论
     * @param id 评论id
     * @return 删除结果
     */
    boolean deleteMessage(int id);
}
