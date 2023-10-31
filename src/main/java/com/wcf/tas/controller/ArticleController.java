package com.wcf.tas.controller;

import com.wcf.tas.entity.ArticleClassVO;
import com.wcf.tas.entity.UserVO;
import com.wcf.tas.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-10-27
 */
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/article/dealArticleClass.do")
    public String dealArticleClass(@ModelAttribute ArticleClassVO ac,HttpServletRequest request) {
        UserVO user=(UserVO) request.getSession().getAttribute("user");
        ac.setAddUid(user.getId());

        articleService.dealArticleClass(ac);
        return "articleClassList.do";
    }

    @RequestMapping("/article/articleClassList.do")
    public String articleClassList(HttpServletRequest request,Model model) {
        String idStr = request.getParameter("classId");
        int id = 0;
        if (idStr!= null && !"".equals(idStr)){
            id = Integer.parseInt(idStr);
        }
        ArrayList<ArticleClassVO> acList=articleService.getArticleClassList();
        ArticleClassVO ac = new ArticleClassVO();
        if (id>0){
          ac = articleService.getArticleClassById(id);
        }
        ac = (ac==null ?new ArticleClassVO():ac);
        model.addAttribute("ac",ac);
        model.addAttribute("acList", acList);
        return "articleClassList.jsp";
    }

    @RequestMapping("/article/articleClassDelete.do")
     public String aeticleClass(@RequestParam int classId){
        articleService.deleteArticleClassById(classId);
        return "articleClassList.do";
    }
}