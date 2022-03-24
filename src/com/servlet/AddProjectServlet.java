package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ProjectDBHelp;
import com.entity.Project;

public class AddProjectServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String usercode = req.getParameter("usercode");
	
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
		

		ProjectDBHelp db = new ProjectDBHelp();
		
		Project p = new Project();
		p.setName(name);
		p.setContent(content);	
		p.setUsercode(usercode);
		
		 //毫秒数的时间戳
        String code = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
         //设置编码
        p.setCode(code);
        p.setCreateTime(new Date().toLocaleString());
		

		try {
			
			db.update(p);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		resp.sendRedirect("admin/projectManagement.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
