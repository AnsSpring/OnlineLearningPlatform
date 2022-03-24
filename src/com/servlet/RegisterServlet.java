package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.AdminDBHelp;
import com.entity.Admin;
import com.util.Common;

/**
 * 管理员注册
 * @author Administrator
 *
 */
public class RegisterServlet extends HttpServlet{
	

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		password = new String(password.getBytes("ISO-8859-1"), "UTF-8");

		AdminDBHelp db = new AdminDBHelp();

		ArrayList<Admin> list = db.query();
		
		for(int i = 0; i < list.size(); i++){
			
			if(list.get(i).getUsername().equals(Common.filterSpace(username))&& 
					list.get(i).getPassword().equals(Common.filterSpace(password))){
				
				req.setAttribute("error", "用户名和密码已经存在");
				req.getRequestDispatcher("admin/register.jsp").forward(req, resp);
				
				return;
			}
			
		}
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		//设置为管理员角色
		admin.setRole("1");
		 //毫秒数的时间戳
        String code = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
         //设置用户编码
        admin.setUsercode(code);
        admin.setCreateBy("管理员");
        admin.setCreateTime(new Date().toLocaleString());

		try {
			
			db.update(admin);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.setAttribute("success", "已经成功注册，请登录!!");
		req.getRequestDispatcher("admin/login.jsp").forward(req,resp);

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doPost(req, resp);
	}

}
