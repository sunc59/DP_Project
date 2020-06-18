package com.sunc.shop.service;


import com.sunc.shop.dao.FavoriteDao;
import com.sunc.shop.dao.ProductDao;
import com.sunc.shop.model.Favorite;
import com.sunc.shop.model.Product;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/18 23:42
 */
public class FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDao();

    private ProductDao productDao = new ProductDao();

    public Favorite findIdId(String pid, String uid) {
        Favorite favorite = favoriteDao.findByIds(pid,uid);
        return favorite;
    }

    public void addFavorite(String uid, String pid) {
        favoriteDao.add(uid,pid);
    }

    public List<Favorite> findRank() {
        List<Favorite> list = favoriteDao.findFavoriteRank();

        return list;
    }

    public int findCount(String id) {
        int count = favoriteDao.findFavoriteCount(id);
        return count;
    }

    public List<Product> findMyFavorite(int id) {
        return favoriteDao.findMyFavorite(id);
    }
}
