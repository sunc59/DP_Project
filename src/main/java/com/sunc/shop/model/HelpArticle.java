package com.sunc.shop.model;

/**
 * @auther sunc
 * @date 2020/6/16 18:59
 */
public class HelpArticle {

    private int id;
    private int cid;
    private String title;
    private String content;

    private HelpCategory category;

    @Override
    public String toString() {
        return "HelpArticle{" +
                "id=" + id +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public HelpCategory getCategory() {
        return category;
    }

    public void setCategory(HelpCategory category) {
        this.category = category;
    }
}
