package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.JudgeQuestion;


public class JudgeQuestionDBHelp {
	
	 // 根据id来修改数据
	public void modify(JudgeQuestion j) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE judge_question SET pcode ='").append(j.getPcode());
			sql.append("',content='").append(j.getContent());
			sql.append("',answer='").append(j.getAnswer());
			sql.append("',score='").append(j.getScore());
			sql.append("'WHERE id = ").append(j.getId());
			
//			System.out.println(sql.toString());


			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
    //插入数据
	public void update(JudgeQuestion j) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO judge_question(pcode,content,answer,score,create_time) ");
			sql.append("VALUES(?,?,?,?,?)");
			
//			System.out.println(sql.toString());

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, j.getPcode());
			preparedStatement.setString(2, j.getContent());
			preparedStatement.setString(3, j.getAnswer());
			preparedStatement.setString(4, j.getScore());
			preparedStatement.setString(5, j.getCreateTime());
			

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	// 根据id来删除数据
	public void delete(int id) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "DELETE FROM judge_question WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

    
	//查询数据
	public ArrayList<JudgeQuestion> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JudgeQuestion>  list = new ArrayList<JudgeQuestion>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

//			String sql = " SELECT T.* " + "FROM judge_question T";
			
			String sql = " SELECT A.NAME,T.* FROM judge_question T JOIN SUBJECT A ON T.PCODE = A.CODE";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				JudgeQuestion j = new JudgeQuestion();
				
				j.setName(rs.getString(1));
				
				j.setId(rs.getInt(2));
				j.setPcode(rs.getString(3));
				j.setContent(rs.getString(4));
				j.setAnswer(rs.getString(5));
				j.setScore(rs.getString(6));
				j.setCreateTime(rs.getString(7));

				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<JudgeQuestion> queryByCode(String pcode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<JudgeQuestion>  list = new ArrayList<JudgeQuestion>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
	        StringBuffer sql = new StringBuffer(); 
			
			sql.append("SELECT T.* FROM judge_question T");
			sql.append(" WHERE T.pcode = '").append(pcode);
			sql.append("' ORDER BY T.ID ASC");

		//	String sql = " SELECT A.NAME,T.* FROM single_choice T JOIN SUBJECT A ON T.PCODE = A.CODE";
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				JudgeQuestion j = new JudgeQuestion();
				
				j.setId(rs.getInt(1));
				j.setPcode(rs.getString(2));
				j.setContent(rs.getString(3));
				j.setAnswer(rs.getString(4));
				j.setScore(rs.getString(5));
				j.setCreateTime(rs.getString(6));
				

				list.add(j);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}


}


