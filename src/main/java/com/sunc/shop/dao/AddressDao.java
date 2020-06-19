package com.sunc.shop.dao;

import com.sunc.shop.model.Address;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/20 23:16
 */
public class AddressDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public void insertAddress(Address address, String uid) {
        String sql = "insert into address set receiverAddress=? ,receiverName=? ," +
                "receiverGender=? ,receiverPhone=? ,uid=? ";
        List<Object> params = new ArrayList<Object>();
        params.add(address.getReceiverAddress());
        params.add(address.getReceiverName());
        params.add(address.getReceiverGender());
        params.add(address.getReceiverPhone());
        params.add(uid);
        template.update(sql,params.toArray());
    }


    public List<Address> findByUserId(String uid) {
        String sql = "select * from address where uid=?";
        List<Address> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Address>(Address.class),uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(String id) {
        String sql = "delete from address where id=?";
        template.update(sql,id);
    }

    public Address findById(String id) {
        String sql = "select * from address where id=?";
        Address address = null;
        try {
            address = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Address>(Address.class),id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return address;
    }

}