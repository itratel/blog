package com.itratel.model;


import java.util.Date;

public class Message {
    /***
     * 主键
     */
    private int id;
    /***
     * 标题
     */
    private int title;
    /***
     * 具体内容
     */
    private int content;
    /***
     * 日期
     */
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
