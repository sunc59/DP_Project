package com.sunc.shop.service;

import com.sunc.shop.dao.HelpDao;
import com.sunc.shop.model.HelpArticle;
import com.sunc.shop.model.HelpCategory;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/16 19:02
 */
public class HelpService {

    private HelpDao helpDao = new HelpDao();

    public List<HelpArticle> findAllByCid(String cid) {
        return helpDao.findAllByCid(cid);
    }

    public List<HelpCategory> findAllCategory() {
        List<HelpCategory> list = helpDao.findAllCategory();
        for (HelpCategory helpCategory : list) {
            List<HelpArticle> articles = helpDao.findAllByCid(helpCategory.getId() + "");
            helpCategory.setList(articles);
        }
        return list;
    }
}
