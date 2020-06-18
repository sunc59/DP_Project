package com.sunc.shop.model;

/**
 * @auther sunc
 * @date 2020/4/17 20:59
 */
public class Category {

    private int id;
    private String name;
    // List<Product> list;


    @Override
    public String toString() {
        return "Category{" +
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
