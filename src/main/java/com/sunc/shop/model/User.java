package com.sunc.shop.model;


import java.util.Date;

/**
 * @auther sunc
 * @date 2020/4/17 21:47
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String email;
    private String telephone;
    private String activeCode;
    private String state;
    private int role_id;
    private Date registTime;
    private Role role;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private String reviewName;

    public String getReviewName() {
        if (nickname==null||"".equals(nickname)) {
            return "昵***称";
        }else {
            StringBuilder s = new StringBuilder();
            s.append(nickname.charAt(0));
            for (int i = 1; i < nickname.length() - 1; i++) {
                s.append("*");
            }
            s.append(nickname.charAt(nickname.length() - 1));
            return s.toString();
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", activeCode='" + activeCode + '\'' +
                ", state=" + state +
                ", registTime=" + registTime +
                '}';
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {

        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }
}
