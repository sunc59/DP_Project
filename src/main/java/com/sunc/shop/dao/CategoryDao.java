package com.sunc.shop.dao;

import com.sunc.shop.model.Category;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/17 21:05
 */
public class CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Category> findAll() {
        String sql = "select * from category";
        List<Category> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Category findById(String cid) {
        String sql = "select * from category where id=?";
        Category category = null;
        try {
            category = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Category>(Category.class),cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    public void updateCategory(String id, String name) {
        String sql = "update category set name=? where id=?";
        template.update(sql,name,id);
    }

    public void deleteCategory(String cid) {
        String sql = "delete from category where id=?";
        template.update(sql,cid);
    }

    public void addCategory(String name) {
        String sql = "insert into category(name) values(?)";
        template.update(sql,name);
    }
}
