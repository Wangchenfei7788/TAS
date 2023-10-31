package com.wcf.tas.dao;

import com.wcf.tas.entity.ArticleClassVO;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author root
 * @since 2023-10-27
 */
public interface IArticleDAO {
    /**
     * @param ac
     * @return
     */

 public int addArticleClass(ArticleClassVO ac);

    int modifyArticleClass(ArticleClassVO ac);

    ArrayList<ArticleClassVO> getArticleClassList();



    ArticleClassVO getArticleClassById(int classId);
    public int deleteArticleClassById(int classId);
}
