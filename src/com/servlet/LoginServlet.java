package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.AdminDBHelp;
import com.entity.Admin;
import com.entity.LoginUser;

public class LoginServlet extends HttpServlet {

//	private static final Logger log = Logger.getLogger(LoginServlet.class); 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8"); 
		password = new String(password.getBytes("ISO-8859-1"), "UTF-8"); 
		
		
		AdminDBHelp db = new AdminDBHelp();
		ArrayList<Admin> list = db.query();
		
		//判断登录用户的角色是否正确
		LoginUser lu = db.queryLoginInfo(username);
		
		System.out.println("登陆者的信息是========>" + lu);
		if(lu.getId() != null && lu.getRole() > 1){
			
			StringBuffer sb = new StringBuffer();
			sb.append("该用户是").append(lu.getRoleValue()).append("!");
			req.setAttribute("role", sb.toString());
			req.getRequestDispatcher("admin/login.jsp").forward(req, resp);
			return;
		}
		


		for (int i = 0; i < list.size(); i++) {

			// 登录成功
			if (username.equals(list.get(i).getUsername())
					&& password.equals(list.get(i).getPassword())) {

//				log.info(username +"登录了!");
				
				System.out.println(username +"登录了!");
				
				HttpSession session = req.getSession();
				session.setAttribute("lu", lu);
				req.getRequestDispatcher("admin/management.jsp").forward(req,resp);
				
				return;
			}

		}
	    
		req.setAttribute("error", "账号或密码错误");
		req.getRequestDispatcher("admin/login.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}