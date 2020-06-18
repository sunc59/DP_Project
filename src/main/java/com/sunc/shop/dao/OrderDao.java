package com.sunc.shop.dao;

import com.sunc.shop.model.Address;
import com.sunc.shop.model.Order;
import com.sunc.shop.model.User;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/21 9:24
 */
public class OrderDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  插入返回自增主键
     */
    public int insertGetId(Order order) {
        /**
         *  order表名要加引号，因为order在mysql中是关键字
         */
        String sql = "insert into orders(uid,aid,money,status,createTime,orderCode)\n" +
                "values(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1,order.getUser().getId());
                ps.setInt(2,order.getAddress().getId());
                ps.setDouble(3,order.getMoney());
                ps.setInt(4,order.getStatus());
                ps.setTimestamp(5, new Timestamp(order.getCreateTime().getTime()));
                ps.setString(6,order.getOrderCode());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Order findOrderByOrderId(String oid) {
        String sql =    "select o.*,a.*,u.* \n" +
                        "from orders o,address a,user u \n" +
                        "where o.aid=a.id and o.uid=u.id and o.id=?";
        Order order = template.queryForObject(sql, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                // 封装Order基本数据
                Order order = new Order();
                String orderCode = resultSet.getString("orderCode");
                double money = resultSet.getDouble("money");
                int status = resultSet.getInt("status");
                Date createTime = resultSet.getDate("createTime");
                order.setId(Integer.parseInt(oid));
                order.setOrderCode(orderCode);
                order.setMoney(money);
                order.setStatus(status);
                order.setCreateTime(createTime);

                // 封装Address信息
                Address address = new Address();
                int aid = resultSet.getInt("aid");
                String receiverAddress = resultSet.getString("receiverAddress");
                String receiverName = resultSet.getString("receiverName");
                String receiverGender = resultSet.getString("receiverGender");
                String receiverPhone = resultSet.getString("receiverPhone");
                address.setId(aid);
                address.setReceiverAddress(receiverAddress);
                address.setReceiverName(receiverName);
                address.setReceiverGender(receiverGender);
                address.setReceiverPhone(receiverPhone);

                order.setAddress(address);
                return order;
            }
        },oid);

        return order;
    }

    public void confirmPayOrder(String oid) {
        String sql = "update orders set status=?,payTime=? where id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(2);
        params.add(new Date());
        params.add(oid);
        template.update(sql,params.toArray());
    }


    /**
     * 根据用户id查询所有订单
     * @param uid
     * @return
     */
    public List<Order> findAllOrderByUserId(int uid) {
        String sql =    "select o.*,a.*,u.* \n" +
                        "from orders o,address a,user u \n" +
                        "where o.aid=a.id and o.uid=u.id and o.uid=?";
        List<Order> list = template.query(sql, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                // 封装Order基本数据
                Order order = new Order();
                int id = resultSet.getInt("id");
                String orderCode = resultSet.getString("orderCode");
                double money = resultSet.getDouble("money");
                int status = resultSet.getInt("status");
                Date createTime = resultSet.getDate("createTime");
                order.setId(id);
                order.setOrderCode(orderCode);
                order.setMoney(money);
                order.setStatus(status);
                order.setCreateTime(createTime);
                // 封装Address信息
                Address address = new Address();
                int aid = resultSet.getInt("aid");
                String receiverAddress = resultSet.getString("receiverAddress");
                String receiverName = resultSet.getString("receiverName");
                String receiverGender = resultSet.getString("receiverGender");
                String receiverPhone = resultSet.getString("receiverPhone");
                address.setId(aid);
                address.setReceiverAddress(receiverAddress);
                address.setReceiverName(receiverName);
                address.setReceiverGender(receiverGender);
                address.setReceiverPhone(receiverPhone);

                order.setAddress(address);
                return order;
            }
        }, uid);
        return list;
    }

    public void getStatus(String oid) {
        String sql = "update orders set status=?,confirmTime=? where id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(4);
        params.add(new Date());
        params.add(oid);
        template.update(sql,params.toArray());
    }
    public void reviewStatus(String oid) {
        String sql = "update orders set status=?,confirmTime=? where id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(5);
        params.add(new Date());
        params.add(oid);
        template.update(sql,params.toArray());
    }


    /**
     *  查询所有订单的详情信息
     */
    public List<Order> findAllOrders() {
        String sql =    "select o.*,a.*,u.* \n" +
                "from orders o,address a,user u \n" +
                "where o.aid=a.id and o.uid=u.id";
        List<Order> list = null;
        try {
            list = template.query(sql, new RowMapper<Order>() {
                @Override
                public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                    // 封装Order基本数据
                    Order order = new Order();
                    int id = resultSet.getInt("id");
                    String orderCode = resultSet.getString("orderCode");
                    double money = resultSet.getDouble("money");
                    int status = resultSet.getInt("status");
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date createTime = resultSet.getTimestamp("createTime");
                    Date payTime = resultSet.getTimestamp("payTime");
                    Date deliveryTime = resultSet.getTimestamp("deliveryTime");
                    Date confirmTime = resultSet.getTimestamp("confirmTime");
                    order.setId(id);
                    order.setOrderCode(orderCode);
                    order.setMoney(money);
                    order.setStatus(status);
                    order.setCreateTime(createTime);
                    order.setPayTime(payTime);
                    order.setDeliveryTime(deliveryTime);
                    order.setConfirmTime(confirmTime);

                    // 封装Address信息
                    Address address = new Address();
                    int aid = resultSet.getInt("aid");
                    String receiverAddress = resultSet.getString("receiverAddress");
                    String receiverName = resultSet.getString("receiverName");
                    String receiverGender = resultSet.getString("receiverGender");
                    String receiverPhone = resultSet.getString("receiverPhone");
                    address.setId(aid);
                    address.setReceiverAddress(receiverAddress);
                    address.setReceiverName(receiverName);
                    address.setReceiverGender(receiverGender);
                    address.setReceiverPhone(receiverPhone);

                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setNickname(resultSet.getString("nickname"));

                    order.setUser(user);
                    order.setAddress(address);
                    return order;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     *  后台功能，修改订单状态为已发货
     * @param oid
     */
    public void faHuoStatus(String oid) {
        String sql = "update orders set status=?,deliveryTime=? where id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(3);
        params.add(new Date());
        params.add(oid);
        template.update(sql,params.toArray());
    }
}
