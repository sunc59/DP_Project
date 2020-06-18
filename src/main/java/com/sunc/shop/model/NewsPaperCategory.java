package com.sunc.shop.model;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/16 18:46
 */
public class NewsPaperCategory {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "NewsPaperCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
