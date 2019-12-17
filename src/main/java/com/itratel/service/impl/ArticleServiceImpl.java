package com.itratel.service.impl;

import com.itratel.dao.ArticleDao;
import com.itratel.model.Article;
import com.itratel.model.PageInfo;
import com.itratel.service.IArticleService;


/**
 * <p>文章业务层</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class ArticleServiceImpl implements IArticleService {

    private ArticleDao articleDao;

    public ArticleServiceImpl() {
        articleDao = new ArticleDao();
    }

    /***
     * 分页查询文章
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return PageInfo<Article>
     */
    @Override
    public PageInfo<Article> findArticle(int pageNum, int pageSize) {
        return articleDao.findArticle(pageNum, pageSize);
    }

    /***
     * 插入文章
     * @param article 文章
     * @return boolean
     */
    @Override
    public boolean addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    /***
     * 修改文章
     * @param article 文章
     * @return boolean
     */
    @Override
    public boolean updateArticle(Article article, int id) {
        return articleDao.updateArticle(article, id);
    }

    /**
     * 删除文章
     * @param id 文章id
     * @return 删除结果
     */
    @Override
    public boolean deleteArticle(int id) {
        return articleDao.deleteArticle(id);
    }
}