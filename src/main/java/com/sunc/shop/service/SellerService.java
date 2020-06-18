package com.sunc.shop.service;



import com.sunc.shop.dao.SellerDao;
import com.sunc.shop.model.Seller;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/18 19:21
 */
public class SellerService {

    private SellerDao sellerDao = new SellerDao();

    /**
     *  根据name查询某个商家
     * @param sellerName
     * @return
     */
    public List<Seller> findSellerByName(String sellerName) {
        List<Seller> list = sellerDao.findByName(sellerName);
        return list;
    }

    /**
     *  根据id查询某个商家
     * @param id
     * @return
     */
    public Seller findSellerById(String id) {
        Seller seller = sellerDao.findById(id);
        return seller;
    }

    /**
     *  查询所有商家
     * @return
     */
    public List<Seller> findAllSeller() {
        return sellerDao.findAll();
    }

    /**
     *  删除某个商家
     * @param sid
     */
    public void deleteSeller(String sid) {
        sellerDao.deleteById(sid);
    }

    /**
     *  更新某个商家
     * @param seller
     */
    public void updateSeller(Seller seller) {
        sellerDao.update(seller);
    }

    /**
     *  新增一个商家
     * @param seller
     */
    public void addSeller(Seller seller) {
        sellerDao.add(seller);
    }
}
