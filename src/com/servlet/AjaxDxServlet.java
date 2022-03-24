package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ResultDBHelp;
import com.entity.AjaxDx;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxDxServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String usercode = req.getParameter("usercode");
		
		ResultDBHelp db = new ResultDBHelp();
		
		ArrayList<AjaxDx> cr = db.queryByCodeAlaxDx(usercode);
		
//		System.out.println(cr);
		
        ObjectMapper mapper = new ObjectMapper();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/javascript");
		
    	resp.getWriter().print(mapper.writeValueAsString(cr));

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
