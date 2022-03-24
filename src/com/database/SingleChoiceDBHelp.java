package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.SingleChoice;


public class SingleChoiceDBHelp {
	
	 // 根据id来修改数据
	public void modify(SingleChoice sc) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE single_choice SET pcode ='").append(sc.getPcode());
			sql.append("',question='").append(sc.getQuestion());
			sql.append("',one='").append(sc.getOne());
			sql.append("',two='").append(sc.getTwo());
			sql.append("',three='").append(sc.getThree());
			sql.append("',four='").append(sc.getFour());
			sql.append("',answer='").append(sc.getAnswer());
			sql.append("',score='").append(sc.getScore());
			sql.append("'WHERE id = ").append(sc.getId());
			
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
	public void update(SingleChoice sc) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO single_choice(pcode,question,one,two,three,four,answer,score,create_time) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?,?)");
			
//			System.out.println(sql.toString());

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, sc.getPcode());
			preparedStatement.setString(2, sc.getQuestion());
			preparedStatement.setString(3, sc.getOne());
			preparedStatement.setString(4, sc.getTwo());
			preparedStatement.setString(5, sc.getThree());
			preparedStatement.setString(6, sc.getFour());
			preparedStatement.setString(7, sc.getAnswer());
			preparedStatement.setInt(8, sc.getScore());
			preparedStatement.setString(9, sc.getCreateTime());
			

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

			String sql = "DELETE FROM single_choice WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

    
	//查询数据
	public ArrayList<SingleChoice> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SingleChoice>  list = new ArrayList<SingleChoice>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			
			String sql = " SELECT A.NAME,T.* FROM single_choice T JOIN SUBJECT A ON T.PCODE = A.CODE";
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				SingleChoice sc = new SingleChoice();
				
				sc.setName(rs.getString(1));
				sc.setId(rs.getInt(2));
				sc.setPcode(rs.getString(3));
				sc.setQuestion(rs.getString(4));
				sc.setOne(rs.getString(5));
				sc.setTwo(rs.getString(6));
				sc.setThree(rs.getString(7));
				sc.setFour(rs.getString(8));
				sc.setAnswer(rs.getString(9));
				sc.setScore(rs.getInt(10));
				sc.setCreateTime(rs.getString(11));
				

				list.add(sc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	//查询数据
	public ArrayList<SingleChoice> queryByCode(String pcode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SingleChoice>  list = new ArrayList<SingleChoice>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
	        StringBuffer sql = new StringBuffer(); 
			
			sql.append("SELECT T.* FROM single_choice T");
			sql.append(" WHERE T.pcode = '").append(pcode);
			sql.append("' ORDER BY T.ID ASC");

		//	String sql = " SELECT A.NAME,T.* FROM single_choice T JOIN SUBJECT A ON T.PCODE = A.CODE";
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				SingleChoice sc = new SingleChoice();
				
				sc.setId(rs.getInt(1));
				sc.setPcode(rs.getString(2));
				sc.setQuestion(rs.getString(3));
				sc.setOne(rs.getString(4));
				sc.setTwo(rs.getString(5));
				sc.setThree(rs.getString(6));
				sc.setFour(rs.getString(7));
				sc.setAnswer(rs.getString(8));
				sc.setScore(rs.getInt(9));
				sc.setCreateTime(rs.getString(10));
				

				list.add(sc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}


}


