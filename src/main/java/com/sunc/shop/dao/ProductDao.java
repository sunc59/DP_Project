package com.sunc.shop.dao;

import com.sunc.shop.model.Category;
import com.sunc.shop.model.Product;
import com.sunc.shop.model.Seller;
import com.sunc.shop.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/17 23:00
 */
public class ProductDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public Product findById(String id) {
        String sql = "select * from product where id = ?";

        Product product = null;
        try {
            product = template.queryForObject(sql,new BeanPropertyRowMapper<Product>(Product.class),id);
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql2 = "select seller.* FROM product,seller " +
                "WHERE product.sid = seller.id AND product.id=?";
        String sql3 = "select category.* FROM product,category " +
                "WHERE product.cid = category.id AND product.id=?";

        Seller seller = template.queryForObject(sql2,
                    new BeanPropertyRowMapper<Seller>(Seller.class), id);
        Category category = template.queryForObject(sql3,
                    new BeanPropertyRowMapper<Category>(Category.class), id);

        product.setSeller(seller);
        product.setCategory(category);

        return product;
    }



    public List<Product> findAll() {
        String sql = "select * from product";
        List<Product> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Product>(Product.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 为了使Product类带上种类和商家可以有两种方式，一种方式是多表查询
     * 获得结果集之后在挨个封装，但是字段较多，太麻烦了
     * 也可以遍历，生成product之后再封装category和seller
     * 虽然简单，但是要多执行几条SQL语句，可能会损耗性能
     *
     */
    public List<Product> findAllByPage(int page, int pageSize) {
        String sql = "select * from product limit ?,?";
        int start = (page-1)*pageSize;
        int end = pageSize;
        List<Product> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql2 = "select seller.* FROM product,seller " +
                "WHERE product.sid = seller.id AND product.id=?";
        String sql3 = "select category.* FROM product,category " +
                "WHERE product.cid = category.id AND product.id=?";
        for (Product product : list) {
            Seller seller = template.queryForObject(sql2,
                    new BeanPropertyRowMapper<Seller>(Seller.class), product.getId());
            Category category = template.queryForObject(sql3,
                    new BeanPropertyRowMapper<Category>(Category.class), product.getId());
            product.setSeller(seller);
            product.setCategory(category);
        }
        return list;
    }

    public int findCount() {
        String sql = "select count(*) from product ";
        int i = template.queryForObject(sql, Integer.class);
        return i;
    }

    public int findCountById(String id) {
        String sql = "select count(*) from product where cid=?";
        int i = template.queryForObject(sql, Integer.class,id);
        return i;
    }
    public int findCountBySearchName(String productName) {
        String sql = "select count(*) from product where name like "+
                " '%"+productName+"%' ";

        int i = template.queryForObject(sql, Integer.class);
        return i;
    }

    public List<Product> findAllByPageId(int page, int pageSize, String id) {

        String sql = "select * from product where cid=? limit ?,?";
        int start = (page-1)*pageSize;
        int end = pageSize;
        List<Product> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),id,start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql2 = "select seller.* FROM product,seller " +
                "WHERE product.sid = seller.id AND product.id=?";
        String sql3 = "select category.* FROM product,category " +
                "WHERE product.cid = category.id AND product.id=?";
        for (Product product : list) {
            Seller seller = template.queryForObject(sql2,
                    new BeanPropertyRowMapper<Seller>(Seller.class), product.getId());
            Category category = template.queryForObject(sql3,
                    new BeanPropertyRowMapper<Category>(Category.class), product.getId());
            product.setSeller(seller);
            product.setCategory(category);
        }
        return list;
    }

    public List<Product> findAllByPageSearchName(int page, int pageSize, String productName) {

        String sql = "select * from product where name like "+
                " '%"+productName+"%' ";
        sql += " limit ?,?";
        int start = (page-1)*pageSize;
        int end = pageSize;
        List<Product> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),start,end);
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql2 = "select seller.* FROM product,seller " +
                "WHERE product.sid = seller.id AND product.id=?";
        String sql3 = "select category.* FROM product,category " +
                "WHERE product.cid = category.id AND product.id=?";
        for (Product product : list) {
            Seller seller = template.queryForObject(sql2,
                    new BeanPropertyRowMapper<Seller>(Seller.class), product.getId());
            Category category = template.queryForObject(sql3,
                    new BeanPropertyRowMapper<Category>(Category.class), product.getId());
            product.setSeller(seller);
            product.setCategory(category);
        }
        return list;
    }

    public Category findCategoryById(String id) {
        String sql = "select * from category where id=?";
        Category category = template.queryForObject(sql,
                new BeanPropertyRowMapper<Category>(Category.class), id);
        return category;
    }

    public void updateStock(int pid, int number) {
        String sql = "update product set stock=stock-? where id=?";
        template.update(sql,number,pid);
    }



    public int findTotalCount(int cid, String pName) {
        String sql = "select count(*) from product where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        if (cid!=0){
            params.add(cid);
            sb.append(" and cid=? ");
        }
        if (pName!=null&&pName.length()>0){
            params.add("%"+pName+"%");
            sb.append(" and name like ?");
        }
        sql = sb.toString();
        System.out.println(sql);
        return template.queryForObject(sql,Integer.class,params.toArray());

    }

    public List<Product> findByPage(int cid, String pName, int start, int pageSize) {
        String sql = "select * from product where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        if (cid!=0){
            params.add(cid);
            sb.append(" and cid=? ");
        }
        if (pName!=null&&pName.length()>0){
            params.add("%"+pName+"%");
            sb.append(" and name like ? ");
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(pageSize);
        sql = sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),params.toArray());

    }

    /**
     * 查询某个商家的所有商品
     * @param sid
     * @return
     */
    public List<Product> findAllBySid(String sid) {
        String sql = "select * from product where sid=?";
        List<Product> list = null;
        try {
            list = template.query(sql,new BeanPropertyRowMapper<Product>(Product.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 后台更新商品
     * @param product
     */
    public void updateProduct(Product product) {
        String sql = "update product set name=?," +
                "subTitle=?,price=?,promotePrice=?,stock=? where id=?";

        List<Object> params = new ArrayList<Object>();
        params.add(product.getName());
        params.add(product.getSubTitle());
        params.add(product.getPrice());
        params.add(product.getPromotePrice());
        params.add(product.getStock());
        params.add(product.getId());

        template.update(sql,params.toArray());
    }

    /**
     *  后台删除某个商品
     * @param pid
     */
    public void deleteProduct(String pid) {
        String sql = "delete from product where id=?";
        template.update(sql,pid);
    }

    /**
     *  后台增加一个商品
     * @param product
     */
    public void addProduct(Product product) {
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(null);
        params.add(product.getName());
        params.add(product.getSubTitle());
        params.add(product.getPrice());
        params.add(product.getPromotePrice());
        params.add(product.getStock());
        params.add(product.getCid());
        params.add(product.getSid());
        params.add(new Date());

        template.update(sql,params.toArray());
    }
}
