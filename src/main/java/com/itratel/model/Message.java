package com.itratel.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>留言实体</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class Message {
    /***
     * 主键
     */
    private int id;
    /***
     * 具体内容
     */
    private String content;
    /***
     * 日期
     */
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public Message(Map<String, Object> map) {

    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public List toList() {
        List<String> list = new ArrayList<>();
        list.add(content);
        list.add(date);
        return list;
    }
}
