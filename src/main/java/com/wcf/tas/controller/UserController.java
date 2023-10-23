package com.wcf.tas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcf.tas.dao.impl.UserDAO;
import com.wcf.tas.entity.UserVO;
import com.wcf.tas.MD5;

@Controller
public class UserController {

	@RequestMapping("/userLogin.do")
	public String validatelogin(HttpServletRequest request) throws Exception {

		request.setCharacterEncoding("UTF-8"); // ???????????
		String usr = request.getParameter("username"); // ????????????
		String pwd = request.getParameter("userpwd"); // ???????????
		String tp = request.getParameter("usertype"); // ???????????
		boolean validated = false; // ?????????

		UserVO user = new UserVO();
		user.setUserName(usr);
		user.setUserPwd(MD5.MD5Encode(pwd));
		user.setUserType(tp);

		UserDAO dao = new UserDAO();
		user = dao.validateUser(user);

		if (user != null) {
			user.setUserPwd(pwd);
			request.getSession().setAttribute("user", user);
			return "redirect:frmWeb/frmMain.jsp";
		} else {
			return "redirect:error.jsp";
		}

	}
}
