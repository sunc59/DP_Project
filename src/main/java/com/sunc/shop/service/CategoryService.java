package com.sunc.shop.service;

import com.sunc.shop.dao.CategoryDao;
import com.sunc.shop.dao.ProductDao;
import com.sunc.shop.dao.PropertyDao;
import com.sunc.shop.model.Category;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/17 21:04
 */
public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public List<Category> findAllCategory() {
        List<Category> list = categoryDao.findAll();
        return list;
    }

    public Category findCategory(String cid) {
        return categoryDao.findById(cid);
    }

    public void updateCategory(String id, String name) {
        categoryDao.updateCategory(id,name);
    }

    /**
     * 要删除某个商品类别，首先要删除该类别的所有属性和商品
     * 先删除该类别的所有属性，再删除该类别下的所有商品
     * 最后删除该类别的信息
     * 但是在MySQL中设置了级联删除，就直接删除就可以了
     * @param cid
     */
    public void deleteCategory(String cid) {
        // new PropertyDao().deletePropertyByCid(cid);
        // new ProductDao().deleteProductByCid(cid);
        categoryDao.deleteCategory(cid);
    }

    public void addCategory(String name) {
        categoryDao.addCategory(name);
    }
}
