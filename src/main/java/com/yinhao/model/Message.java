package com.yinhao.model;


import static com.yinhao.constant.Constants.GUEST_ZH;
import static com.yinhao.util.StrUtil.randomString;

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
     * 文章id
     */
    private int aId;

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

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
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
                ", aId=" + aId +
                ", critics='" + critics + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static Object[] getParams(Message message) {
        return new Object[]{message.getaId(), message.getContent(), GUEST_ZH + randomString(8)};
    }
}
