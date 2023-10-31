package com.wcf.tas.service;

import com.wcf.tas.entity.ArticleClassVO;

import java.util.ArrayList;

public interface IArticleService {

	public int dealArticleClass(ArticleClassVO ac);
	public int modifyArticleClass(ArticleClassVO ac);
	public ArrayList<ArticleClassVO> getArticleClassList();
	public ArticleClassVO getArticleClassById(int classId);
	public int deleteArticleClassById(int classId);
}
