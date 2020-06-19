package com.sunc.shop.service;

import com.sunc.shop.dao.PropertyDao;
import com.sunc.shop.dao.PropertyValueDao;
import com.sunc.shop.model.Property;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/18 15:46
 */
public class PropertyService {

    private PropertyDao propertyDao = new PropertyDao();
    //private PropertyValueDao propertyValueDao = new PropertyValueDao();

    public List<Property> findAllPropertyByCid(String cid) {
        return propertyDao.findAllByCid(cid);
    }

    /**
     *  要删除某个属性，先要删除该属性的所有值
     *  先删除所有属性值，再删除该属性
     *  但是在MySQL中设置了级联删除，就直接删除就可以了
     * @param pid
     */
    public void deleteProperty(String pid) {
        //propertyValueDao.deletePropertyValueByPTid(pid);
        propertyDao.deleteProperty(pid);
    }

    public void updateProperty(String pid, String name) {
        propertyDao.updateProperty(pid,name);
    }

    public void addProperty(String name) {
        propertyDao.addProperty(name);
    }


    public Property findPropertyByPid(String pid) {
        return propertyDao.findPropertyByPid(pid);
    }

}
