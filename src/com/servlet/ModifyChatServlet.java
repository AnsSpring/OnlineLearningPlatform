package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ChatDBHelp;
import com.entity.Chat;


public class ModifyChatServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
		String scID = req.getParameter("id");
		String advice = req.getParameter("advice");
		String usercode = req.getParameter("usercode");
	
	
		int id = Integer.parseInt(scID);
		usercode = new String(usercode.getBytes("ISO-8859-1"), "UTF-8");
		advice = new String(advice.getBytes("ISO-8859-1"), "UTF-8");
	
		String[] u = usercode.split(",");
		
		Chat c = new Chat();
		
		c.setId(id);
		c.setAdvice(advice);
	    c.setUsercode(u[0]);
	    c.setUsername(u[1]);
		
		ChatDBHelp cdbh = new ChatDBHelp();
		
		try {
			
			cdbh.modify(c);
			
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
