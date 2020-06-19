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

    private NewsPaperDao newsPaperDao = new NewsPaperDao();

    /**
     *  根据种类id查找所有的快报
     */
    public List<NewsPaper> findAllArticleByCid(String cid) {
        return newsPaperDao.findAllByCid(cid);
    }

    /**
     * 查看所有快报种类
     * @return
     */
    public List<NewsPaperCategory> findAllCategory() {
        return newsPaperDao.findAllCategory();
    }

    /**
     * 删除一个快报种类
     * @param cid
     */
    public void deleteCategory(String cid) {
        newsPaperDao.deleteCategory(cid);
    }

    /**
     * 增加一个快报种类
     * @param name
     */
    public void addCategory(String name) {
        newsPaperDao.addCategory(name);
    }

    /**
     *  根据id查找一个具体的快报
     */
    public NewsPaper findArticle(String aid) {
        return newsPaperDao.findArticle(aid);
    }

    /**
     *  新增一个快报
     */
    public void addArticle(NewsPaper newsPaper) {
        newsPaperDao.addArticle(newsPaper);
    }

    /**
     *  更新一个快报
     */
    public void updateArticle(NewsPaper newsPaper) {
        newsPaperDao.updateArticle(newsPaper);
    }

    /**
     *  删除一个快报
     */
    public void deleteArticle(String aid) {
        newsPaperDao.deleteArticle(aid);
    }

    /**
     * 增加文章访问量
     * @param aid
     */
    public void changeArticleCount(String aid) {
        newsPaperDao.changeArticleCount(aid);
    }
}
