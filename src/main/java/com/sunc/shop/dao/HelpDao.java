package com.sunc.shop.dao;

import com.sunc.shop.model.HelpArticle;
import com.sunc.shop.model.HelpCategory;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/16 19:03
 */
public class HelpDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<HelpArticle> findAllByCid(String cid) {
        String sql = "select * from helparticle where cid = ?";
        List<HelpArticle> list = null;
        try {
            list = template.query(sql,
                    new BeanPropertyRowMapper<HelpArticle>(HelpArticle.class),cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<HelpCategory> findAllCategory() {
        String sql = "select * from helparticle";
        List<HelpCategory> list = template.query(sql,
                new BeanPropertyRowMapper<HelpCategory>(HelpCategory.class));
        return list;
    }
}
