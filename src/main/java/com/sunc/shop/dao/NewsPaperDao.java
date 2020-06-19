package com.sunc.shop.dao;

import com.sunc.shop.model.NewsPaper;
import com.sunc.shop.model.NewsPaperCategory;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 查看所有快报种类
     * @return
     */
    public List<NewsPaperCategory> findAllCategory() {
        String sql = "select * from newspapercategory";
        List<NewsPaperCategory> list = template.query(sql,
                new BeanPropertyRowMapper<NewsPaperCategory>(NewsPaperCategory.class));
        return list;
    }

    /**
     * 删除一个快报种类
     * @param cid
     */
    public void deleteCategory(String cid) {
        String sql = "delete from newspapercategory where id=?";
        template.update(sql,cid);
    }

    /**
     * 增加一个快报种类
     * @param name
     */
    public void addCategory(String name) {
        String sql = "insert into newspapercategory values(?,?)";
        template.update(sql,null,name);
    }

    /**
     *  查一个快报
     */
    public NewsPaper findArticle(String aid) {
        String sql = "select * from newspaper where id=?";
        NewsPaper newsPaper = template.queryForObject(sql,
                new BeanPropertyRowMapper<NewsPaper>(NewsPaper.class), aid);
        return newsPaper;
    }

    /**
     *  新增一个快报
     */
    public void addArticle(NewsPaper newsPaper) {
        String sql = "insert into newspaper values(?,?,?,?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(null);
        params.add(newsPaper.getTitle());
        params.add(newsPaper.getContent());
        params.add(newsPaper.getCid());
        params.add(newsPaper.getUid());
        params.add(newsPaper.getCount());
        params.add(new Date());

        template.update(sql,params.toArray());
    }

    /**
     * 删除快报
     * @param aid
     */
    public void deleteArticle(String aid) {
        String sql = "delete from newspaper where id=?";
        template.update(sql,aid);
    }

    /**
     * 更新快报
     * 只更新标题和内容和访问量
     */
    public void updateArticle(NewsPaper newsPaper) {
        String sql = "update newspaper set title=?,content=?,count=? where id=?";
        template.update(sql,newsPaper.getTitle(), newsPaper.getContent(),
                            newsPaper.getCount(),newsPaper.getId());
    }

    /**
     * 增加文章访问量
     * @param aid
     */
    public void changeArticleCount(String aid) {
        String sql = "update newspaper set count=count+1 where id=?";
        template.update(sql,aid);
    }
}
