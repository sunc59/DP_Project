package com.sunc.shop.dao;

import com.sunc.shop.model.NewsPaper;
import com.sunc.shop.model.NewsPaperCategory;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/15 23:43
 */
public class NewsPaperDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<NewsPaper> findAllByCid(String cid) {
        String sql = "select * from newspaper where cid=?";
        List<NewsPaper> list = null;
        try {
            list = template.query(sql,
                    new BeanPropertyRowMapper<NewsPaper>(NewsPaper.class),cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<NewsPaperCategory> findAllCategory() {
        String sql = "select * from newspapercategory";
        List<NewsPaperCategory> list = template.query(sql,
                new BeanPropertyRowMapper<NewsPaperCategory>(NewsPaperCategory.class));
        return list;
    }
}
