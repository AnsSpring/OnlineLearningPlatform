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

public class AddAdminServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		//��ʼ����Ĭ�����û�������һ��
		String password = req.getParameter("username");
		String realName = req.getParameter("realName");
		String classAndGrade = req.getParameter("classAndGrade");
		String age = req.getParameter("age");
		String mail = req.getParameter("mail");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		String sex = req.getParameter("sex");

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
		

		AdminDBHelp db = new AdminDBHelp();

		ArrayList<Admin> list = db.query();
		
		for(int i = 0; i < list.size(); i++){
			
			if(list.get(i).getUsername().equals(Common.filterSpace(username))){
				
				req.setAttribute("error", "�û����Ѿ����ڣ��û��������ظ�");
				req.getRequestDispatcher("admin/addAdmin.jsp").forward(req, resp);
				
				return;
			}
			
		}
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setRealName(realName);
		admin.setClassAndGrade(classAndGrade);
		admin.setMail(mail);
		admin.setPhone(phone);
		admin.setAddress(address);
		admin.setAge(age);
		admin.setRole(role);
		admin.setSex(sex);
		
		
		
		 //��������ʱ���
        String code = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
         //�����û�����
        admin.setUsercode(code);
        admin.setCreateTime(new Date().toLocaleString());
		

		try {
			
			db.update(admin);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		resp.sendRedirect("admin/adminManagement.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
