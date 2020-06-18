package com.sunc.shop.model;

import java.util.Date;

/**
 * @auther sunc
 * @date 2020/6/15 23:45
 */
public class NewsPaper {
    private int id;
    private String title;
    private String content;
    private int cid;
    private int uid;
    private int count;
    private Date createTime;

    private NewsPaperCategory category;
    private User user;


    @Override
    public String toString() {
        return "NewsPaper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", cid=" + cid +
                ", uid=" + uid +
                ", count=" + count +
                ", createTime=" + createTime +
                ", category=" + category +
                ", user=" + user +
                '}';
    }

    public NewsPaperCategory getCategory() {
        return category;
    }

    public void setCategory(NewsPaperCategory category) {
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
