package com.sunc.shop.service;

import com.sunc.shop.dao.RoleDao;
import com.sunc.shop.model.Role;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/18 19:24
 */
public class RoleService {

    private RoleDao roleDao = new RoleDao();

    /**
     *  查找所有角色
     * @return
     */
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    /**
     *  查找某个角色
     * @return
     * @param rid
     */
    public Role findRole(String rid) {
        return roleDao.findById(Integer.parseInt(rid));
    }

    /**
     *  删除某个角色
     * @param rid
     */
    public void deleteRole(String rid) {
        roleDao.deleteById(rid);
    }

    /**
     *  更新某个角色
     * @param role
     */
    public void updateRole(Role role) {
        roleDao.update(role);
    }

    /**
     *  新增一个角色
     * @param name
     * @param description
     */
    public void addRole(String name, String description) {
        roleDao.add(name,description);
    }
}
