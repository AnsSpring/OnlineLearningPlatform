package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ChatDBHelp;
import com.entity.AjaxChat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxChatServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

//		String usercode = req.getParameter("usercode");
		
		ChatDBHelp db = new ChatDBHelp();
		
		ArrayList<AjaxChat> cr = db.queryAjaxInfo();
		
		
        ObjectMapper mapper = new ObjectMapper();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/javascript");
		
    	resp.getWriter().print(mapper.writeValueAsString(cr));

//		resp.sendRedirect("admin/adminManagement.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
