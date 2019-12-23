package com.yinhao.model;


/**
 * <p>留言实体-返回对象</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class MessageVo {
    /***
     * 主键
     */
    private int id;

    /***
     * 文章id
     */
    private String title;

    /***
     * 评论人
     */
    private String critics;

    /***
     * 具体内容
     */
    private String content;

    /***
     * 评论日期
     */
    private String date;

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

    public String getCritics() {
        return critics;
    }

    public void setCritics(String critics) {
        this.critics = critics;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title=" + title +
                ", critics='" + critics + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
