package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.JudgeQuestionDBHelp;
import com.entity.JudgeQuestion;

public class AddJudgeQuestionServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");

		String pcode = req.getParameter("pcode");
		String content = req.getParameter("content");
		String answer = req.getParameter("answer");
		String score = req.getParameter("score");
	
		pcode = new String(pcode.getBytes("ISO-8859-1"), "UTF-8");
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
		answer = new String(answer.getBytes("ISO-8859-1"), "UTF-8");
		score = new String(score.getBytes("ISO-8859-1"), "UTF-8");
		

		JudgeQuestionDBHelp db = new JudgeQuestionDBHelp();
		
		JudgeQuestion j = new JudgeQuestion();
		j.setPcode(pcode);
	    j.setContent(content);
		j.setAnswer(answer);
		j.setScore(score);
        j.setCreateTime(new Date().toLocaleString());
		

		try {
			
			db.update(j);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("admin/jqManagement.jsp");;
		
		resp.sendRedirect("admin/jqManagement.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
