package com.sunc.shop.dao;

import com.sunc.shop.model.HelpArticle;
import com.sunc.shop.model.HelpCategory;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/16 19:03
 */
public class HelpDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  查询该类别下所有文章
     */
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

    /**
     *  查询所有类别
     * @return
     */
    public List<HelpCategory> findAllCategory() {
        String sql = "select * from helparticle";
        List<HelpCategory> list = template.query(sql,
                new BeanPropertyRowMapper<HelpCategory>(HelpCategory.class));
        return list;
    }

    /**
     *  查询某个文章
     * @param hid
     * @return
     */
    public HelpArticle findHelpById(String hid) {
        String sql = "select * from helparticle where id=?";
        HelpArticle article = template.queryForObject(sql,
                new BeanPropertyRowMapper<HelpArticle>(HelpArticle.class), hid);
        return article;
    }

    /**
     * 增加一个帮助种类
     * @param name
     */
    public void addCategory(String name) {
        String sql = "insert into helpcategory values(?,?)";
        template.update(sql,null,name);
    }

    /**
     * 删除一个帮助文章种类
     * @param cid
     */
    public void deleteCategory(String cid) {
        String sql = "delete from helpcategory where id=?";
        template.update(sql,cid);
    }

    /**
     * 新增一篇文章
     * @param article
     */
    public void addArticle(HelpArticle article) {
        String sql = "insert into helparticle values(?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(null);
        params.add(article.getCid());
        params.add(article.getTitle());
        params.add(article.getContent());

        template.update(sql,params.toArray());

    }

    /**
     * 删除一篇文章
     * @param aid
     */
    public void deleteArticle(String aid) {
        String sql = "delete from helparticle where id=?";
        template.update(sql,aid);
    }
}
