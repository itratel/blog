package com.yinhao.model;

/**
 * <p>用户实体</p>
 * @author yinhao
 * @date 2019/12/18 00:55
 */
public class User {
    /***
     * 主键
     */
    private int id;
    /***
     * 用户名
     */
    private String username;
    /***
     * 密码
     */
    private String password;
    /***
     * 性别
     */
    private String sex;
    /***
     * 邮箱
     */
    private String email;
    /***
     * 图片url
     */
    private String imgUrl;
    /***
     * 兴趣
     */
    private String hobby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
