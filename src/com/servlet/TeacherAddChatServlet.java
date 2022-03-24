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

public class TeacherAddChatServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String pcode = req.getParameter("pcode");
		String pname = req.getParameter("pname");
		String usercode = req.getParameter("usercode");
		String realName = req.getParameter("realName");
		String advice = req.getParameter("advice");
	
	
		pcode = new String(pcode.getBytes("ISO-8859-1"), "UTF-8");
		pname = new String(pname.getBytes("ISO-8859-1"), "UTF-8");
		usercode = new String(usercode.getBytes("ISO-8859-1"), "UTF-8");
		realName = new String(realName.getBytes("ISO-8859-1"), "UTF-8");
		advice = new String(advice.getBytes("ISO-8859-1"), "UTF-8");
			

		ChatDBHelp db = new ChatDBHelp();
		
		Chat c = new Chat();
		c.setCode(pcode);
		c.setName(pname);
		c.setUsercode(usercode);
		c.setUsername(realName);	
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
