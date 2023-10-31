package com.wcf.tas.dao.impl;

import com.wcf.tas.dao.BaseDAO;
import com.wcf.tas.dao.IArticleDAO;
import com.wcf.tas.entity.ArticleClassVO;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class ArticleDAO extends BaseDAO implements IArticleDAO {

    @Override
    public int addArticleClass(ArticleClassVO ac) {
        SqlSession session = this.getSession();
        IArticleDAO mapper = session.getMapper(IArticleDAO.class);
        int num = mapper.addArticleClass(ac);
        session.commit();
        session.close();
        return num;
    }
    @Override
    public int modifyArticleClass(ArticleClassVO ac) {
        SqlSession session = this.getSession();
        IArticleDAO mapper = session.getMapper(IArticleDAO.class);
        int num = mapper.modifyArticleClass(ac);
        session.commit();
        session.close();
        return num;
    }
    @Override
    public ArrayList<ArticleClassVO> getArticleClassList() {
        SqlSession session = this.getSession();
        IArticleDAO mapper = session.getMapper(IArticleDAO.class);
        ArrayList<ArticleClassVO> aclist =mapper.getArticleClassList();
        return aclist;
    }
    @Override
    public ArticleClassVO getArticleClassById(int classId) {
        SqlSession session = this.getSession();
        IArticleDAO mapper = session.getMapper(IArticleDAO.class);
        return mapper.getArticleClassById(classId);
    }

    @Override
    public int deleteArticleClassById(int classId) {
        SqlSession session = this.getSession();
        IArticleDAO mapper = session.getMapper(IArticleDAO.class);
        int num = mapper.deleteArticleClassById(classId);
        session.commit();
        session.close();
        return num;
    }
}
