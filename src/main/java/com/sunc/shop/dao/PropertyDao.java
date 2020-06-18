package com.sunc.shop.dao;

import com.sunc.shop.model.Property;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/18 15:46
 */
public class PropertyDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Property> findAllByCid(String cid) {
        String sql = "select * from property where cid=?";
        List<Property> list = null;
        try {
            list = template.query(sql,
                    new BeanPropertyRowMapper<Property>(Property.class),cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void deleteProperty(String pid) {
        String sql = "delete from property where id=?";
        template.update(sql,pid);
    }

    public void updateProperty(String pid, String name) {
        String sql = "update property set name=? where id=?";
        template.update(sql,name,pid);
    }

    public void addProperty(String name) {
        String sql = "insert into property(name) values(?)";
        template.update(sql,name);
    }

    public Property findPropertyByPid(String pid) {
        String sql = "select * from property where id=?";
        Property property = null;
        try {
            property = template.queryForObject(sql, new BeanPropertyRowMapper<Property>(Property.class), pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return property;
    }
}
