package com.wcf.tas.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcf.tas.entity.UserVO;
import com.wcf.tas.service.impl.UserService;
import com.wcf.tas.MD5;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/userLogin.do")
	public String validatelogin(HttpServletRequest request,Model model) throws Exception {

		request.setCharacterEncoding("UTF-8"); // 设置请求编码
		String usr = request.getParameter("username"); // 获取提交的用户名
		String pwd = request.getParameter("userpwd"); // 获取提交的密码
		String tp = request.getParameter("usertype"); // 获取提交的类型
		UserVO user = new UserVO();
		user.setUserName(usr);
		user.setUserPwd(MD5.MD5Encode(pwd));
		user.setUserType(tp);

		//UserDAO dao = new UserDAO();
		user = userService.validateUser(user);

		if (user != null) {
			user.setUserPwd(pwd);
			request.getSession().setAttribute("user", user);
			return "redirect:frmWeb/frmMain.jsp";
		} else {
			model.addAttribute("action", "登陆");
			model.addAttribute("action_info", "登陆失败");
			model.addAttribute("next_info", "返回登陆界面重新登录");
			model.addAttribute("next_url", "location.href='login.html'");
			return "include/oper_info.jsp";
		}
	}

	@RequestMapping("/regUser.do")
	public String userReg(HttpServletRequest request,Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");			//设置请求编码
		String usr=request.getParameter("username");			//获取提交的用户名
		String pwd=request.getParameter("userpwd");		//获取提交的密码
		String tp=request.getParameter("usertype");		//获取提交的类型

		UserVO user = new UserVO();
		user.setUserName(usr);
		user.setUserPwd(MD5.MD5Encode(pwd));
		user.setUserType(tp);
		int num=userService.regUser(user);

		model.addAttribute("action", "注册");
		if(num>0)
		{
			model.addAttribute("action_info", "注册成功");
			model.addAttribute("next_info", "登陆界面进行登录");
			model.addAttribute("next_url", "location.href='login.html'");
		}
		else
		{
			model.addAttribute("action_info", "注册失败");
			model.addAttribute("next_info", "重新注册");
			model.addAttribute("next_url", "location.href='reg.html'");
		}
		return "include/oper_info.jsp";
	}
	@RequestMapping("/checkUser.do")
	public void checkUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String username=request.getParameter("username");
		//TODO
		boolean isExist=userService.isExistUserByName(username);

		PrintWriter out=response.getWriter();

		if(isExist) {
			out.println("true");
		}else {
			out.println("false");
		}
		out.flush();
		out.close();
	}
}