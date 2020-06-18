package com.sunc.shop.dao;


import com.sunc.shop.model.Role;
import com.sunc.shop.model.User;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/17 21:47
 */
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User findUserByUP(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        User user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    public User findUserByUP2(String username, String password) {
        String sql = "SELECT u.*,r.* from user u,role r \n" +
                "where u.role_id=r.id and u.username=? and u.password=?";
        User user = null;
        try {
            user = template.queryForObject(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User u = new User();
                    int id = resultSet.getInt("id");
                    String nickname = resultSet.getString("nickname");
                    String gender = resultSet.getString("gender");
                    String email = resultSet.getString("email");
                    String telephone = resultSet.getString("telephone");
                    String activeCode = resultSet.getString("activeCode");
                    String state = resultSet.getString("state");
                    java.util.Date registTime = (java.util.Date)resultSet.getTimestamp("registTime");

                    u.setId(id);
                    u.setUsername(username);
                    u.setPassword(password);
                    u.setNickname(nickname);
                    u.setGender(gender);
                    u.setEmail(email);
                    u.setTelephone(telephone);
                    u.setActiveCode(activeCode);
                    u.setState(state);
                    u.setRegistTime(registTime);

                    Role role = new Role();
                    role.setId(resultSet.getInt("r.id"));
                    role.setName(resultSet.getString("name"));
                    role.setDescription(resultSet.getString("description"));

                    u.setRole(role);
                    return u;
                }
            },username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    public void addUser(User user) {
        String sql = "insert into user set username=? ,password=? ," +
                "email=?,state=?,role_id=?,registTime=?";
        List<Object> params = new ArrayList<Object>();
        params.add(user.getUsername());
        params.add(user.getPassword());
        params.add(user.getEmail());
        params.add("N");
        params.add(1);
        params.add(user.getRegistTime());
        template.update(sql, params.toArray());
    }

    public void updateUser(User user) {
        String sql = "update user set nickname=?,email=?," +
                        "password=? ,gender = ?,telephone=? " +
                        "where id = ? ";
        template.update(sql,user.getNickname(),user.getEmail(),user.getPassword(),user.getGender(),
                user.getTelephone(),user.getId());
    }

    public User findUserById(int uid) {
        String sql = "select * from user where id=?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), uid);
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAllUser() {
        String sql = "SELECT u.*,r.* from user u,role r \n" +
                     "where u.role_id=r.id ";
        List<User> list = null;

        try {
            list = template.query(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User u = new User();
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String nickname = resultSet.getString("nickname");
                    String gender = resultSet.getString("gender");
                    String email = resultSet.getString("email");
                    String telephone = resultSet.getString("telephone");
                    String activeCode = resultSet.getString("activeCode");
                    String state = resultSet.getString("state");
                    Date registTime = resultSet.getDate("registTime");

                    u.setId(id);
                    u.setUsername(username);
                    u.setPassword(password);
                    u.setNickname(nickname);
                    u.setGender(gender);
                    u.setEmail(email);
                    u.setTelephone(telephone);
                    u.setActiveCode(activeCode);
                    u.setState(state);
                    u.setRegistTime(registTime);

                    Role role = new Role();
                    role.setId(resultSet.getInt("r.id"));
                    role.setName(resultSet.getString("name"));
                    role.setDescription(resultSet.getString("description"));

                    u.setRole(role);
                    return u;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public User findUserByUsername(String username) {
        String sql = "select * from user where username=?";
        User user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public void updateUserInfo(User user) {
        String sql = "update user set password=?, nickname=?,gender=?," +
                "telephone=? where id = ? ";
        template.update(sql,user.getPassword(),user.getNickname(),user.getGender(),
                user.getTelephone(),user.getId());
    }

    /**
     *  后台功能，辅助激活用户
     * @param uid
     */
    public void activeUser(String uid) {
        String sql = "update user set state=? where id=?";
        template.update(sql,"Y",uid);
    }

    /**
     *  后台功能，更改用户角色
     */
    public void updateRoleId(String uid, String rid) {
        String sql = "update user set state=? where id=?";
        template.update(sql,rid,uid);
    }
}
