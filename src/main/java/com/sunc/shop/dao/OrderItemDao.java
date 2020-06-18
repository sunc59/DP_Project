package com.sunc.shop.dao;

import com.sunc.shop.model.OrderItem;
import com.sunc.shop.model.Product;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/21 13:48
 */
public class OrderItemDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void insertOrderItem(OrderItem orderItem) {
        String sql = "insert into orderitem(oid,pid,number) values(?,?,?)";
        template.update(sql,orderItem.getOrder().getId(),
                                orderItem.getProduct().getId(),orderItem.getNumber());

    }

    public List<OrderItem> findOrderItemByOrderId(String oid) {
        String sql =    "select oi.*,p.* " +
                        "from orderitem oi,product p " +
                        "where oi.pid=p.id and oi.oid=?";
        List<OrderItem> list = template.query(sql, new RowMapper<OrderItem>() {
            @Override
            public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
                OrderItem orderItem = new OrderItem();
                int id = resultSet.getInt("id");
                int number = resultSet.getInt("number");
                orderItem.setId(id);
                orderItem.setNumber(number);

                // 封装Product
                Product product = new Product();
                int pid = resultSet.getInt("pid");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double promotePrice = resultSet.getDouble("promotePrice");
                product.setId(pid);
                product.setName(name);
                product.setPrice(price);
                product.setPromotePrice(promotePrice);

                orderItem.setProduct(product);
                return orderItem;
            }
        },oid);
        return list;
    }
}
