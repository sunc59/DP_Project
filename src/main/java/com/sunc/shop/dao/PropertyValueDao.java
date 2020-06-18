package com.sunc.shop.dao;

import com.sunc.shop.model.Property;
import com.sunc.shop.model.PropertyValue;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/23 16:45
 */
public class PropertyValueDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *  查询某个商品的所有属性值
     */
    public List<PropertyValue> findAllPVByPId(String pid) {
        String sql = "select pt.*,p.name from property p,propertyvalue pt,product pp \n" +
                     "where pt.pid=pp.id and pt.ptid=p.id and pt.pid=?";

        List<PropertyValue> list = null;

        try {
            list = template.query(sql, new RowMapper<PropertyValue>() {
                @Override
                public PropertyValue mapRow(ResultSet resultSet, int i) throws SQLException {

                    PropertyValue propertyValue = new PropertyValue();
                    int id = resultSet.getInt("id");
                    String value = resultSet.getString("value");
                    propertyValue.setId(id);
                    propertyValue.setValue(value);

                    Property property = new Property();
                    String name = resultSet.getString("name");
                    property.setName(name);

                    propertyValue.setProperty(property);
                    return propertyValue;
                }
            }, pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     *  为某商品增加一个属性值
     * @param pid
     * @param ptid
     * @param value
     */
    public void addPropertyValue(String pid, String ptid, String value) {
        String sql = "insert into propertyvalue values(?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(null);
        params.add(pid);
        params.add(ptid);
        params.add(value);

        template.update(sql,params.toArray());
    }

    /**
     *  删除某个属性值
     * @param id
     */
    public void deletePropertyValue(String id) {
        String sql = "delete from propertyvalue where id=?";
        template.update(sql,id);
    }

    /**
     *  修改某个属性值
     * @param id
     * @param value
     */
    public void updatePropertyValue(String id, String value) {
        String sql = "update propertyvalue set value=? where id=?";
        template.update(sql,value,id);
    }
}
