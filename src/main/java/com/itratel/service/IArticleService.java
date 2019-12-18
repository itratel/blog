package com.itratel.service;

import com.itratel.model.Article;
import com.itratel.model.PageInfo;

/**
 * <p>文章业务层接口</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public interface IArticleService {

    /***
     * 分页查询文章
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return PageInfo<Article>
     */
    PageInfo<Article> listArticle(int pageNum, int pageSize);


    /***
     * 插入文章
     * @param article 文章
     * @return boolean
     */
    boolean addArticle(Article article);


    /***
     * 修改文章
     * @param article 文章
     * @param id 主键
     * @return boolean
     */
    boolean updateArticle(Article article, int id);

    /**
     * 删除文章
     * @param id 文章id
     * @return 删除结果
     */
    boolean deleteArticle(int id);
}
