package com.yinhao.model;

/**
 * <p>文章实体</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class Article {
    /***
     * 主键
     */
    private int id;
    /***
     * 标题
     */
    private String title;
    /***
     * md内容
     */
    private String mdContent;
    /***
     * html内容
     */
    private String htmlContent;
    /***
     * 日期
     */
    private String date;

    public Article() {
    }

    public Article(int id, String title, String mdContent, String htmlContent, String date) {
        this.id = id;
        this.title = title;
        this.mdContent = mdContent;
        this.htmlContent = htmlContent;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static Object[] getParams(Article article) {
        return new Object[]{article.getTitle(), article.getMdContent(), article.getHtmlContent()};
    }

}
