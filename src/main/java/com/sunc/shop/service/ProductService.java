package com.sunc.shop.service;

import com.sunc.shop.dao.OrderItemDao;
import com.sunc.shop.dao.ProductDao;
import com.sunc.shop.model.Category;
import com.sunc.shop.model.OrderItem;
import com.sunc.shop.model.PageBean;
import com.sunc.shop.model.Product;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/17 22:59
 */
public class ProductService {

    private ProductDao productDao = new ProductDao();

    /**
     *  根据id查找单个商品
     * @param id
     * @return
     */
    public Product findProductById(String id) {
        Product product = productDao.findById(id);
        return product;
    }

    /**
     * 无分页查询所有商品
     * @return
     */
    public List<Product> findAllProduct() {
        List<Product> list = productDao.findAll();
        return list;
    }

    /**
     * 后台分页查询所有商品
     * @param spage
     * @param spageSize
     * @return
     */
    public PageBean<Product> findAllProductByPage(String spage, String spageSize) {
        PageBean<Product> pageBean = new PageBean<Product>();
        int page = Integer.parseInt(spage);
        pageBean.setCurrentPage(page);
        int pageSize = Integer.parseInt(spageSize);
        pageBean.setPageSize(pageSize);
        int count = productDao.findCount();
        pageBean.setTotalCount(count);
        int totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;
        pageBean.setTotalPage(totalPage);
        List<Product> list = productDao.findAllByPage(page,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    /**
     *  老版本根据类别分页查询
     * @param spage
     * @param spageSize
     * @param id
     * @return
     */
    public PageBean<Product> findProductByCategory(String spage, String spageSize, String id) {
        PageBean<Product> pageBean = new PageBean<Product>();
        int page = Integer.parseInt(spage);
        pageBean.setCurrentPage(page);
        int pageSize = Integer.parseInt(spageSize);
        pageBean.setPageSize(pageSize);
        int count = productDao.findCountById(id);
        pageBean.setTotalCount(count);
        int totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;
        pageBean.setTotalPage(totalPage);
        List<Product> list = productDao.findAllByPageId(page,pageSize,id);
        pageBean.setList(list);
        return pageBean;
    }

    /**
     *  老版本根据搜索内容分页查询
     * @param spage
     * @param spageSize
     * @param productName
     * @return
     */
    public PageBean<Product> findProductBySearch(String spage, String spageSize, String productName) {

        PageBean<Product> pageBean = new PageBean<Product>();

        int page = Integer.parseInt(spage);
        pageBean.setCurrentPage(page);
        int pageSize = Integer.parseInt(spageSize);
        pageBean.setPageSize(pageSize);
        int count = productDao.findCountBySearchName(productName);
        pageBean.setTotalCount(count);
        int totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;
        pageBean.setTotalPage(totalPage);
        List<Product> list = productDao.findAllByPageSearchName(page,pageSize,productName);
        pageBean.setList(list);
        return pageBean;
    }

    /**
     * 新版本分页查询
     * @param cid
     * @param rname
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Product> pageFind(int cid, String rname, int currentPage, int pageSize) {
        PageBean<Product> pageBean = new PageBean<Product>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        int count = productDao.findTotalCount(cid,rname);
        pageBean.setTotalCount(count);
        int pages = count%pageSize==0?count/pageSize:count/pageSize+1;
        pageBean.setTotalPage(pages);

        List<Product> list = productDao.findByPage(cid,rname,(currentPage-1)*pageSize,pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 根据某个商家的所有商品，商品少就不分页了
     * @param sid
     * @return
     */
    public List<Product> findAllBySid(String sid) {
        return productDao.findAllBySid(sid);
    }


    public Category findCategory(String id) {
        Category category = productDao.findCategoryById(id);
        return category;
    }


    public void updateStockByOrderId(String oid) {
        OrderItemDao orderItemDao = new OrderItemDao();
        List<OrderItem> list = orderItemDao.findOrderItemByOrderId(oid);
        System.out.println(list);
        for (OrderItem item : list) {
            System.out.println(item.getProduct().getId());
            System.out.println(item.getNumber());
            productDao.updateStock(item.getProduct().getId(),item.getNumber());
        }
    }

    /**
     * 后台更新商品
     * @param product
     */
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    /**
     *  后台删除某个商品
     * @param pid
     */
    public void deleteProduct(String pid) {
        productDao.deleteProduct(pid);
    }

    /**
     *  后台新增一个商品
     * @param product
     */
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }
}
