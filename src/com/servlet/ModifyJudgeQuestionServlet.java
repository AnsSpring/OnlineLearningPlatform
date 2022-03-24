package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.JudgeQuestionDBHelp;
import com.entity.JudgeQuestion;


public class ModifyJudgeQuestionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
		String scID = req.getParameter("id");

		String pcode = req.getParameter("pcode");
		String content = req.getParameter("content");
		String answer = req.getParameter("answer");
		String score = req.getParameter("score");
	
		int id = Integer.parseInt(scID);
		pcode = new String(pcode.getBytes("ISO-8859-1"), "UTF-8");
		content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
		answer = new String(answer.getBytes("ISO-8859-1"), "UTF-8");
		score = new String(score.getBytes("ISO-8859-1"), "UTF-8");
				
		JudgeQuestion j = new JudgeQuestion();
		
		j.setId(id);
		j.setPcode(pcode);
		j.setContent(content);	
		j.setAnswer(answer);
		j.setScore(score);

		
		JudgeQuestionDBHelp jqdbh = new JudgeQuestionDBHelp();
		
		try {
			
			jqdbh.modify(j);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/jqManagement.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
