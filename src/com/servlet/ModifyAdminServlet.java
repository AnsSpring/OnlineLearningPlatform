package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.AdminDBHelp;
import com.entity.Admin;


public class ModifyAdminServlet extends HttpServlet {

	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String adminID = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String realName = req.getParameter("realName");
		String classAndGrade = req.getParameter("classAndGrade");
		String age = req.getParameter("age");
		String mail = req.getParameter("mail");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		String sex = req.getParameter("sex");


		adminID= new String(adminID.getBytes("ISO-8859-1"), "UTF-8");
    	int id = Integer.parseInt(adminID);
    	
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8"); 
		password = new String(password.getBytes("ISO-8859-1"), "UTF-8"); 
		
		realName = new String(realName.getBytes("ISO-8859-1"), "UTF-8");
		classAndGrade  = new String(classAndGrade.getBytes("ISO-8859-1"), "UTF-8");
		age = new String(age.getBytes("ISO-8859-1"), "UTF-8");
		mail = new String(mail.getBytes("ISO-8859-1"), "UTF-8");
		phone = new String(phone.getBytes("ISO-8859-1"), "UTF-8");
		address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
		role = new String(role.getBytes("ISO-8859-1"), "UTF-8");
		sex = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
		

		Admin a = new Admin();
		
		a.setId(id);
		a.setUsername(username);
		a.setPassword(password);
		a.setRealName(realName);
		a.setClassAndGrade(classAndGrade);
		a.setMail(mail);
		a.setPhone(phone);
		a.setAddress(address);
		a.setAge(age);
		a.setRole(role);
		a.setSex(sex);

		a.setUpdateTime(new Date().toLocaleString());
		 
		AdminDBHelp adbh = new AdminDBHelp();
		
		try {
			
			adbh.modify(a);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/adminManagement.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
