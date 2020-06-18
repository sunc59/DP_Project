package com.sunc.shop.model;

import java.util.Date;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/21 9:19
 */
public class Order {

    private int id;
    private String orderCode;
    private User user;
    private Address address;
    private double money;
    private int status;
    private Date createTime;
    private Date payTime;
    private Date deliveryTime;
    private Date confirmTime;

    private List<OrderItem> list;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", user=" + user +
                ", address=" + address +
                ", money=" + money +
                ", status=" + status +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", deliveryTime=" + deliveryTime +
                ", confirmTime=" + confirmTime +
                '}';
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }
}
