package com.sunc.shop.service;

import com.sunc.shop.dao.NewsPaperDao;
import com.sunc.shop.model.NewsPaper;
import com.sunc.shop.model.NewsPaperCategory;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/15 23:43
 */
public class NewsPaperService {

    public List<NewsPaper> findAllByCid(String cid) {
        return new NewsPaperDao().findAllByCid(cid);
    }

    public List<NewsPaperCategory> findAllCategory() {
        return new NewsPaperDao().findAllCategory();
    }
}
