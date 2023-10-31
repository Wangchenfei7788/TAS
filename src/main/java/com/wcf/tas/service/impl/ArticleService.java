package com.wcf.tas.service.impl;

import org.springframework.stereotype.Service;

import com.wcf.tas.dao.impl.ArticleDAO;
import com.wcf.tas.entity.ArticleClassVO;
import com.wcf.tas.service.IArticleService;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class ArticleService implements IArticleService {
	
	private ArticleDAO articleDAO;
	
	@Override
	public int dealArticleClass(ArticleClassVO ac) {
		if (ac.getClassId()>0) {
			ac.setModifyDate(new Timestamp(System.currentTimeMillis()));
			return articleDAO.modifyArticleClass(ac);
		}else {
			Timestamp addDate=new Timestamp(System.currentTimeMillis());//填充时间
			ac.setAddDate(addDate);
			return articleDAO.addArticleClass(ac);
		}
    }

	@Override
	public int modifyArticleClass(ArticleClassVO ac) {
		return 0;
	}

	@Override
	public ArrayList<ArticleClassVO> getArticleClassList() {
		return articleDAO.getArticleClassList();
	}

	@Override
	public ArticleClassVO getArticleClassById(int classId) {
		return articleDAO.getArticleClassById(classId);
	}

	@Override
	public int deleteArticleClassById(int classId) {
		return articleDAO.deleteArticleClassById(classId);
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
}
