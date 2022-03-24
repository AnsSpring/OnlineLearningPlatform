package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.BulletinDBHelp;
import com.entity.Bulletin;


public class ModifyBulletinServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		String storyID = request.getParameter("id");
		String topic = request.getParameter("topic");
		String content = request.getParameter("content");
		String isCheck = request.getParameter("isCheck");
		

		storyID= new String(storyID.getBytes("ISO-8859-1"), "UTF-8");
    	int id = Integer.parseInt(storyID);
    	
		topic = new String(topic.getBytes("ISO-8859-1"), "UTF-8"); 
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
		isCheck = new String(isCheck.getBytes("ISO-8859-1"), "UTF-8"); 

		Bulletin bulletin = new Bulletin();
		
		bulletin.setId(id);
		bulletin.setTopic(topic);
		bulletin.setContent(content);
		bulletin.setIsCheck(isCheck);


		BulletinDBHelp bdbh = new BulletinDBHelp();
		
		try {
			
			bdbh.modify(bulletin);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		request.getRequestDispatcher("admin/bulletinManagement.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
