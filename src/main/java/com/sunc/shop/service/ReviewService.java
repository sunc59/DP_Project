package com.sunc.shop.service;


import com.sunc.shop.dao.ReviewDao;
import com.sunc.shop.model.Review;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/23 14:27
 */
public class ReviewService {

    private ReviewDao reviewDao = new ReviewDao();

    /**
     *  前台
     *  增加一个评论信息
     */
    public void addReview(String uid, String pid, String content) {
        reviewDao.addReview(uid,pid,content);
    }

    /**
     *  查找某个商品的所有评论
     */
    public List<Review> findReviewsByPId(String pid){
        List<Review> list = reviewDao.findReviewsByPId(pid);
        return list;
    }

    /**
     *  查找某个用户的所有评论
     */
    public List<Review> findReviewsByUId(String uid) {
        return reviewDao.findReviewsByUId(uid);
    }

    /**
     *  根据id删除评论
     */
    public void deleteReview(String rid) {
        reviewDao.deleteReview(rid);
    }

    /**
     *  查找某个用户关于某件商品的评论
     *  用于后台搜索某个具体评论
     */
    public Review findReviewsByUIdPId(String uid, String pid) {
        return reviewDao.findReviewsByUIdPId(uid,pid);
    }
}
