package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.SingleChoiceDBHelp;
import com.entity.SingleChoice;


public class ModifySingleChoiceServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
		String scID = req.getParameter("id");

		String pcode = req.getParameter("pcode");
		String question = req.getParameter("question");
		String one = req.getParameter("one");
		String two = req.getParameter("two");
		String three = req.getParameter("three");
		String four = req.getParameter("four");
		String answer = req.getParameter("answer");
		String score = req.getParameter("score");
	
		int id = Integer.parseInt(scID);
		pcode = new String(pcode.getBytes("ISO-8859-1"), "UTF-8");
		question = new String(question.getBytes("ISO-8859-1"), "UTF-8");
		one = new String(one.getBytes("ISO-8859-1"), "UTF-8");
		two = new String(two.getBytes("ISO-8859-1"), "UTF-8");
		three = new String(three.getBytes("ISO-8859-1"), "UTF-8");
		four = new String(four.getBytes("ISO-8859-1"), "UTF-8");
		answer = new String(answer.getBytes("ISO-8859-1"), "UTF-8");
		score = new String(score.getBytes("ISO-8859-1"), "UTF-8");
				
		SingleChoice sc = new SingleChoice();
		
		sc.setId(id);
		sc.setPcode(pcode);
		sc.setQuestion(question);	
		sc.setOne(one);
		sc.setTwo(two);
		sc.setThree(three);
		sc.setFour(four);
		sc.setAnswer(answer);
		sc.setScore(Integer.parseInt(score));

		
		SingleChoiceDBHelp scdbh = new SingleChoiceDBHelp();
		
		try {
			
			scdbh.modify(sc);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		req.getRequestDispatcher("admin/scManagement.jsp").forward(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
