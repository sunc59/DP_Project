package com.sunc.shop.dao;

import com.sunc.shop.model.Product;
import com.sunc.shop.model.Seller;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/18 19:21
 */
public class SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  根据name模糊查询商家
     * @param sellerName
     * @return
     */
    public List<Seller> findByName(String sellerName) {
        String sql = " select * from seller where name like '%"+sellerName+"%'";
        List<Seller> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Seller>(Seller.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     *  根据id查询商家
     * @param id
     * @return
     */
    public Seller findById(String id) {
        String sql = "select * from seller where id=?";
        Seller seller = null;
        try {
            seller = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Seller>(Seller.class),id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return seller;
    }

    /**
     *  老版本返回自增主键的增加商家
     * @param seller
     * @return
     */
    public int add222(Seller seller){
        String sql = "insert into seller(name,phone) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,seller.getName());
                preparedStatement.setString(2,seller.getPhone());

                return preparedStatement;
            }
        },keyHolder);
        System.out.println(keyHolder.getKey().intValue());

        return 1;
    }

    /**
     *  查询所有商家
     * @return
     */
    public List<Seller> findAll() {
        String sql = "select * from seller";
        List<Seller> list = template.query(sql,
                new BeanPropertyRowMapper<Seller>(Seller.class));
        return list;
    }

    /**
     *  更新商家
     * @param seller
     */
    public void update(Seller seller) {
        String sql = "update seller set name=?,phone=?," +
                "address=? where id=?";

        List<Object> params = new ArrayList<Object>();
        params.add(seller.getName());
        params.add(seller.getPhone());
        params.add(seller.getAddress());
        params.add(seller.getId());

        template.update(sql,params.toArray());
    }

    /**
     *  根据id删除商家
     * @param sid
     */
    public void deleteById(String sid) {
        String sql = "delete from seller where id=?";
        template.update(sql,sid);
    }

    /**
     * 新增一个商家
     * @param seller
     */
    public void add(Seller seller) {
        String sql = "insert into seller values(?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(seller.getName());
        params.add(seller.getPhone());
        params.add(seller.getAddress());

        template.update(sql,params.toArray());
    }
}
