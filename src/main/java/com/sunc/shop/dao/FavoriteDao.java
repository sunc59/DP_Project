package com.sunc.shop.dao;


import com.sunc.shop.model.Favorite;
import com.sunc.shop.model.Product;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/18 23:42
 */
public class FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public Favorite findByIds(String pid, String uid) {
        String sql = "select * from favorite where uid=? and pid=?";
        Favorite favorite = null;
        try {
            favorite = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return favorite;
    }

    public void add(String uid, String pid) {
        String sql = "insert into favorite set uid=?,pid=?,time=?";
        Date date = new Date();
        template.update(sql,uid,pid,date);
    }

    public List<Favorite> findFavoriteRank() {

        String sql = "select pid,time,count(pid) AS count from favorite group by pid order by count(pid)DESC LIMIT 0,5";


        List<Favorite> fs = template.query(sql, new RowMapper<Favorite>() {

            @Override
            public Favorite mapRow(ResultSet resultSet, int i) throws SQLException {
                int pid = resultSet.getInt("pid");

                Date time = resultSet.getTime("time");
                int count = resultSet.getInt("count");
                Favorite favorite = new Favorite();
                favorite.setCount(count);
                favorite.setTime(time);
                Product product = new ProductDao().findById(pid + "");

                favorite.setProduct(product);
                return favorite;
            }
        });

        return fs;
    }
    public int findFavoriteCount(String pid){
        int i = 0;
        String sql = "select count(pid) AS count from favorite where pid=? group by pid";
        try {
            i = template.queryForObject(sql, Integer.class, pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }




    public List<Product> findMyFavorite(int id) {
        String sql = "SELECT p.* from favorite f,product p where f.pid = p.id and f.uid = ?";
        List<Product> list = null;
        try {
            list = template.query(sql, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setSubTitle(resultSet.getString("subTitle"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setPromotePrice(resultSet.getDouble("promotePrice"));
                    return product;
                }
            },id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        FavoriteDao dao = new FavoriteDao();
        List<Product> list = dao.findMyFavorite(3);
        System.out.println(list);
    }
}
