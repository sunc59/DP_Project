package com.sunc.shop.model;

import java.util.Date;

/**
 * @auther sunc
 * @date 2020/4/18 23:45
 */
public class Favorite {

    private int id;
    private User user;
    private Product product;
    private Date time;

    private int count;

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", time=" + time +
                ", count=" + count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
