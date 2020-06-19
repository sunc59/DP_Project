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

    /**
     *  根据帮助的类别查询该类别下所有文章
     */
    public List<HelpArticle> findAllByCid(String cid) {
        return helpDao.findAllByCid(cid);
    }

    /**
     *  查询所有的帮助中心的类别及文章
     * @return
     */
    public List<HelpCategory> findAllCategory() {
        List<HelpCategory> list = helpDao.findAllCategory();
        for (HelpCategory helpCategory : list) {
            List<HelpArticle> articles = helpDao.findAllByCid(helpCategory.getId() + "");
            helpCategory.setList(articles);
        }
        return list;
    }

    /**
     * 根据id查询某一个具体的文章
     * @param hid
     * @return
     */
    public HelpArticle findHelpById(String hid) {
        return helpDao.findHelpById(hid);
    }

    /**
     * 增加一个帮助文章种类
     * @param name
     */
    public void addCategory(String name) {
        helpDao.addCategory(name);
    }

    /**
     * 删除一个帮助种类
     * @param cid
     */
    public void deleteCategory(String cid) {
        helpDao.deleteCategory(cid);
    }

    /**
     * 新增一篇文章
     * @param article
     */
    public void addArticle(HelpArticle article) {
        helpDao.addArticle(article);
    }

    /**
     * 删除一篇文章
     * @param aid
     */
    public void deleteArticle(String aid) {
        helpDao.deleteArticle(aid);
    }
}
