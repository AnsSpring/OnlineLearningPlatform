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


public class StudentModifyAdminServlet extends HttpServlet {

	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String adminID = req.getParameter("id");
		String password = req.getParameter("password");
		String mail = req.getParameter("mail");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");


		adminID= new String(adminID.getBytes("ISO-8859-1"), "UTF-8");
    	int id = Integer.parseInt(adminID);
    	
		password = new String(password.getBytes("ISO-8859-1"), "UTF-8"); 
		mail = new String(mail.getBytes("ISO-8859-1"), "UTF-8");
		phone = new String(phone.getBytes("ISO-8859-1"), "UTF-8");
		address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
		

		Admin a = new Admin();
		
		a.setId(id);
		a.setPassword(password);
		a.setMail(mail);
		a.setPhone(phone);
		a.setAddress(address);

		a.setUpdateTime(new Date().toLocaleString());
		 
		AdminDBHelp adbh = new AdminDBHelp();
		
		try {
			
			adbh.StudentModify(a);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/studentInfo.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
