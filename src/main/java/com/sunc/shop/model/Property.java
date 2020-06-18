package com.sunc.shop.model;

/**
 * @auther sunc
 * @date 2020/4/23 16:42
 */
public class Property {

    private int id;
    private Category category;
    private String name;

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
