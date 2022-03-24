package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.BulletinDBHelp;
import com.entity.Bulletin;


public class AddBulletinServlet extends HttpServlet {

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");

		String topic = request.getParameter("topic");
		String content = request.getParameter("content");

		topic = new String(topic.getBytes("ISO-8859-1"), "UTF-8");
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8");

		Bulletin bulletin = new Bulletin();

		bulletin.setTopic(topic);
		bulletin.setContent(content);
		bulletin.setCreateTime(new Date().toLocaleString());
		bulletin.setIsCheck("0");
		
		BulletinDBHelp bdb = new BulletinDBHelp();
		
		try {
			bdb.update(bulletin);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		response.sendRedirect("admin/bulletinManagement.jsp");
		
	//	request.getRequestDispatcher("admin/bulletinManagement.jsp").forward(request, response);

	}

		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
