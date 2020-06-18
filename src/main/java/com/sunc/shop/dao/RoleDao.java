package com.sunc.shop.dao;

import com.sunc.shop.model.Role;
import com.sunc.shop.model.Seller;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/5/17 14:16
 */
public class RoleDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  根据id查找某个角色
     * @param id
     * @return
     */
    public Role findById(int id) {
        String sql = "select * from role where id = ?";
        Role role = null;
        try {
            role = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Role>(Role.class),id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }

    /**
     *  查找所有角色
     * @return
     */
    public List<Role> findAll() {
        String sql = "select * from role";
        List<Role> list = new ArrayList<Role>();
        try {
            list = template.query(sql,
                    new BeanPropertyRowMapper<Role>(Role.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     *  删除某个角色
     * @param rid
     */
    public void deleteById(String rid) {
        String sql = "delete from role where id = ?";
        template.update(sql,rid);
    }

    /**
     *  更新某个角色
     * @param role
     */
    public void update(Role role) {
        String sql = "update role set name=?,description=? where id=?";
        template.update(sql,role.getName(),
                role.getDescription(),role.getId());
    }

    /**
     *  新增一个角色
     * @param name
     * @param description
     */
    public void add(String name, String description) {
        String sql = "insert into role values(?,?,?)";
        template.update(sql,null,name,description);
    }
}
