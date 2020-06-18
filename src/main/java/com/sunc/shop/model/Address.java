package com.sunc.shop.model;

/**
 * @auther sunc
 * @date 2020/4/20 23:16
 */
public class Address {

    private int id;
    private String receiverAddress;
    private String receiverName;
    private String receiverGender;
    private String receiverPhone;
    private int uid;
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverGender='" + receiverGender + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", user=" + user +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverGender() {
        return receiverGender;
    }

    public void setReceiverGender(String receiverGender) {
        this.receiverGender = receiverGender;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
