package com.sunc.shop.service;


import com.sunc.shop.dao.PropertyValueDao;
import com.sunc.shop.model.PropertyValue;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/23 16:45
 */
public class PropertyValueService {

    private PropertyValueDao propertyValueDao = new PropertyValueDao();

    /**
     *  查询某个商品的所有属性值
     */
    public List<PropertyValue> findAllPVByPId(String pid){
        List<PropertyValue> list = propertyValueDao.findAllPVByPId(pid);
        return list;
    }

    /**
     * 后台为某商品增加一个属性值
     * @param pid
     * @param ptid
     * @param value
     */
    public void addPropertyValue(String pid, String ptid, String value) {
        propertyValueDao.addPropertyValue(pid,ptid,value);
    }

    /**
     * 删除某个属性值
     * @param id
     */
    public void deletePropertyValue(String id) {
        propertyValueDao.deletePropertyValue(id);
    }

    /**
     *  修改某个属性值
     * @param id
     * @param value
     */
    public void updatePropertyValue(String id, String value) {
        propertyValueDao.updatePropertyValue(id,value);
    }
}
