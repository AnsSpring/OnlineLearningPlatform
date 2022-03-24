package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.ResultDBHelp;
import com.database.SingleChoiceDBHelp;
import com.entity.Result;
import com.entity.SingleChoice;

public class SumSingleChoiceServlet extends HttpServlet {
	
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		
		String[] selectedComs = req.getParameterValues("answer"); 
			
		String pcode = req.getParameter("pcode");
		String pname = req.getParameter("pname");
		String usercode = req.getParameter("usercode");
		String realName = req.getParameter("realName");
		
		pcode = new String(pcode.getBytes("ISO-8859-1"), "UTF-8");
		pname = new String(pname.getBytes("ISO-8859-1"), "UTF-8");
		usercode = new String(usercode.getBytes("ISO-8859-1"), "UTF-8");
		realName = new String(realName.getBytes("ISO-8859-1"), "UTF-8");
		Integer totalScore = 0;
		Integer score = 0;
		
		SingleChoiceDBHelp db = new SingleChoiceDBHelp();
		ArrayList<SingleChoice> scList = db.query();
		
		for(int i = 0; i < scList.size(); i++){
			
			SingleChoice sc = scList.get(i);
			// 统计科目总分
			if(sc.getPcode().equals(pcode)){
				
				totalScore = totalScore + sc.getScore();
			}
			
			for(int j = 0; j < selectedComs.length; j++){
				
				// 统计做题得分
				if(sc.getPcode().equals(pcode) && sc.getAnswer().equals(selectedComs[j])){
					
					score = score + sc.getScore();
				}
				
			}
			
			
		}
		
		score = score / selectedComs.length;
		
		Result r = new Result();
		r.setType("1");
		r.setCode(pcode);
		r.setName(pname);
		r.setUsercode(usercode);
		r.setRealName(realName);
		r.setTotalScore(totalScore);
		r.setScore(score);
		r.setCreateTime(new Date().toLocaleString());
		
		ResultDBHelp rdbh = new ResultDBHelp();
		
	    try {
			
			rdbh.update(r);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
        StringBuffer sb = new StringBuffer();
        sb.append("做题提交成功!!" );
        sb.append(pname).append("总分").append(totalScore).append(",");
        sb.append(" 实际得分").append(score);
        
		req.setAttribute("success", sb.toString());
		req.getRequestDispatcher("admin/projectContent.jsp").forward(req, resp);
	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
