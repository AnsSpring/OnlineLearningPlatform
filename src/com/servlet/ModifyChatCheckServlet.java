package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ChatDBHelp;
import com.entity.Chat;


public class ModifyChatCheckServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String adminID = req.getParameter("id");
		String isCheck = req.getParameter("isCheck");

		adminID= new String(adminID.getBytes("ISO-8859-1"), "UTF-8");
    	int id = Integer.parseInt(adminID);
    	
		isCheck = new String(isCheck.getBytes("ISO-8859-1"), "UTF-8"); 
				
    	Chat c = new Chat();
		
		c.setId(id);
		c.setIsCheck(isCheck);
		
		ChatDBHelp pdbh = new ChatDBHelp();
		
		try {
			
			pdbh.modifyCheck(c);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/chatManagement.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
