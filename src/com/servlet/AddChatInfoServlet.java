package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ChatDBHelp;
import com.entity.Chat;

public class AddChatInfoServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String pcode = req.getParameter("pcode");
		String usercode = req.getParameter("usercode");
		String advice = req.getParameter("advice");
	
	
		pcode = new String(pcode.getBytes("ISO-8859-1"), "UTF-8");
		usercode = new String(usercode.getBytes("ISO-8859-1"), "UTF-8");
		advice = new String(advice.getBytes("ISO-8859-1"), "UTF-8");
		
		String[] p = pcode.split(",");
        String[] u = usercode.split(",");		

		ChatDBHelp db = new ChatDBHelp();
		
		Chat c = new Chat();
		c.setCode(p[0]);
		c.setName(p[1]);
		c.setUsercode(u[0]);
		c.setUsername(u[1]);	
		c.setAdvice(advice);	
        c.setCreateTime(new Date().toLocaleString());
        c.setIsCheck("0");
		

		try {
			
			db.update(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("admin/teacherChatInfo.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
