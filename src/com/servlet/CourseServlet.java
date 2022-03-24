package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.CourseDBHelp;
import com.entity.Course;

public class CourseServlet extends HttpServlet {
	

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
	
		String usercode = req.getParameter("usercode");
		String realName = req.getParameter("realName");
		
		usercode = new String(usercode.getBytes("ISO-8859-1"), "UTF-8");
		realName = new String(realName.getBytes("ISO-8859-1"), "UTF-8");
		
		String[] box = req.getParameterValues("box");
		
		CourseDBHelp db = new CourseDBHelp();
		
		for(int i = 0; i < box.length; i++){
			
		    Course c = new Course();
			String str = new String(box[i].getBytes("ISO-8859-1"), "UTF-8");
			String pcode = str.split("&")[0];
			String pname = str.split("&")[1];
			c.setCode(pcode);
			c.setName(pname);
			c.setUsercode(usercode);
			c.setRealName(realName);
			c.setCreateTime(new Date().toLocaleString());
			
			Integer n = db.getCourseIsExsit(usercode, pcode);
			
			
			if(n==0){
				
				try {
					db.update(c);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		req.getRequestDispatcher("admin/courseInfos.jsp").forward(req, resp);
	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
