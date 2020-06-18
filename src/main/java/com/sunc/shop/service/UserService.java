package com.sunc.shop.service;



import com.sunc.shop.dao.RoleDao;
import com.sunc.shop.dao.UserDao;
import com.sunc.shop.model.User;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/17 21:47
 */
public class UserService {

    UserDao userDao = new UserDao();

    RoleDao roleDao = new RoleDao();

    public User login(String username, String password) {
        User user = userDao.findUserByUP(username,password);
        if (user!=null) {
            user.setRole(roleDao.findById(user.getRole_id()));
        }
        return user;
    }

    public boolean register(User user) {
        // User u = userDao.findUserByUP(user.getUsername(), user.getPassword());
        User u = userDao.findUserByUsername(user.getUsername());
        if (u==null){
            userDao.addUser(user);
            return true;
        }else {
            return false;
        }
    }

    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }


    public void updateUser(User user) {
        userDao.updateUserInfo(user);
    }

    /**
     *  后台功能，辅助激活用户
     * @param uid
     */
    public void activeUser(String uid) {
        userDao.activeUser(uid);
    }

    /**
     *  后台功能，更改用户的角色
     */
    public void updateRoleId(String uid, String rid) {
        userDao.updateRoleId(uid,rid);
    }
}
