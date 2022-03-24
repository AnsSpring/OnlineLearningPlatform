package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ProjectDBHelp;
import com.entity.Project;


public class ModifyProjectServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String adminID = req.getParameter("id");
		String pname = req.getParameter("pname");
		String content = req.getParameter("content");

		adminID= new String(adminID.getBytes("ISO-8859-1"), "UTF-8");
    	int id = Integer.parseInt(adminID);
    	
		pname = new String(pname.getBytes("ISO-8859-1"), "UTF-8"); 
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8"); 
				
		Project p = new Project();
		
		p.setId(id);
		p.setName(pname);
		p.setContent(content);
		
		ProjectDBHelp pdbh = new ProjectDBHelp();
		
		try {
			
			pdbh.modify(p);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/projectManagement.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
