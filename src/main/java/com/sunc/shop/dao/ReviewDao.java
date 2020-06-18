package com.sunc.shop.dao;

import com.sunc.shop.model.Review;
import com.sunc.shop.model.User;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/23 14:28
 */
public class ReviewDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  前台新增一个某用户对某商品的评论
     */
    public void addReview(String uid, String pid, String content) {
        String sql = "insert into review values(null,?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(content);
        params.add(uid);
        params.add(pid);
        params.add(new Date());
        template.update(sql,params.toArray());
    }

    /**
     *  查找某个商品的所有评论
     */
    public List<Review> findReviewsByPId(String pid) {
        String sql = "select r.*,u.* from review r,user u " +
                     "where r.uid=u.id and r.pid=?";
        List<Review> list = null;
        try {
            list = template.query(sql, new RowMapper<Review>() {
                @Override
                public Review mapRow(ResultSet resultSet, int i) throws SQLException {
                    Review review = new Review();
                    int id = resultSet.getInt("id");
                    String content = resultSet.getString("content");
                    Date createTime = resultSet.getDate("createTime");
                    review.setId(id);
                    review.setContent(content);
                    review.setCreateTime(createTime);

                    User user = new User();
                    String nickname = resultSet.getString("nickname");
                    user.setNickname(nickname);

                    review.setUser(user);
                    return review;
                }
            },pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     *  查找某个用户的所有评论
     */
    public List<Review> findReviewsByUId(String uid) {
        String sql = "select r.*,u.* from review r,user u " +
                "where r.uid=u.id and r.uid=?";
        List<Review> list = null;
        try {
            list = template.query(sql, new RowMapper<Review>() {
                @Override
                public Review mapRow(ResultSet resultSet, int i) throws SQLException {
                    Review review = new Review();
                    int id = resultSet.getInt("id");
                    String content = resultSet.getString("content");
                    Date createTime = resultSet.getDate("createTime");
                    review.setId(id);
                    review.setContent(content);
                    review.setCreateTime(createTime);

                    User user = new User();
                    String nickname = resultSet.getString("nickname");
                    user.setNickname(nickname);

                    review.setUser(user);
                    return review;
                }
            },uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /**
     *  删除某个具体的评论
     */
    public void deleteReview(String rid) {
        String sql = "delete from review where id = ?";
        template.update(sql,rid);
    }

    /**
     *  查找某个用户关于某件商品的评论
     *  后台搜索
     */
    public Review findReviewsByUIdPId(String uid, String pid) {
        String sql = "select * from review where uid=? and pid=?";
        Review review = null;
        try {
            review = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Review>(Review.class),uid,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return review;
    }
}
