package com.sunc.shop.model;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/16 18:58
 */
public class HelpCategory {
    private int id;
    private String name;

    private List<HelpArticle> list;

    @Override
    public String toString() {
        return "HelpCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HelpArticle> getList() {
        return list;
    }

    public void setList(List<HelpArticle> list) {
        this.list = list;
    }
}
