package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.CourseDBHelp;
import com.entity.Course;


public class ModifyCourseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String adminID = req.getParameter("id");
		String isCheck = req.getParameter("isCheck");

		adminID= new String(adminID.getBytes("ISO-8859-1"), "UTF-8");
    	int id = Integer.parseInt(adminID);
    	
		isCheck = new String(isCheck.getBytes("ISO-8859-1"), "UTF-8"); 
				
    	Course c = new Course();
		
		c.setId(id);
		c.setIsCheck(isCheck);
		
		CourseDBHelp pdbh = new CourseDBHelp();
		
		try {
			
			pdbh.modify(c);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/courseManagement.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
