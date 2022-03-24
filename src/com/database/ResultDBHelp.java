package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.AjaxDx;
import com.entity.AjaxPd;
import com.entity.Result;


public class ResultDBHelp {
	
	
    //插入数据
	public void update(Result r) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO exercise_result(type,code,name,user_code,real_name,total_score,score,create_time) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?)");

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, r.getType());
			preparedStatement.setString(2, r.getCode());
			preparedStatement.setString(3, r.getName());
			preparedStatement.setString(4, r.getUsercode());
			preparedStatement.setString(5, r.getRealName());
			preparedStatement.setInt(6, r.getTotalScore());
			preparedStatement.setInt(7, r.getScore());
			preparedStatement.setString(8, r.getCreateTime());
			

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	

	//查询数据
	public ArrayList<Result> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Result>  list = new ArrayList<Result>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = " SELECT (CASE T.type WHEN 1 THEN '选择题' ELSE '判断题' END ) AS type_value,T.*  "
				         + "FROM exercise_result T";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Result r = new Result();
				
				r.setTypeValue(rs.getString(1));
				r.setId(rs.getInt(2));
				r.setType(rs.getString(3));
				r.setCode(rs.getString(4));
				r.setName(rs.getString(5));
				r.setUsercode(rs.getString(6));
				r.setRealName(rs.getString(7));
				r.setTotalScore(rs.getInt(8));
				r.setScore(rs.getInt(9));
				r.setCreateTime(rs.getString(10));
				
//                System.out.println(r.toString());
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	//查询数据
	public ArrayList<Result> queryByCode(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Result>  list = new ArrayList<Result>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 
				
			sql.append("SELECT (CASE T.type WHEN 1 THEN '选择题' ELSE '判断题' END ) AS type_value,T.*");
			sql.append("FROM exercise_result T");
			sql.append(" WHERE T.user_code = '").append(usercode);
		    sql.append("' ORDER BY T.ID DESC");
			

//			String sql = " SELECT (CASE T.type WHEN 1 THEN '选择题' ELSE '判断题' END ) AS type_value,T.*  "
//				         + "FROM exercise_result T";
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				Result r = new Result();
				
				r.setTypeValue(rs.getString(1));
				r.setId(rs.getInt(2));
				r.setType(rs.getString(3));
				r.setCode(rs.getString(4));
				r.setName(rs.getString(5));
				r.setUsercode(rs.getString(6));
				r.setRealName(rs.getString(7));
				r.setTotalScore(rs.getInt(8));
				r.setScore(rs.getInt(9));
				r.setCreateTime(rs.getString(10));
				
                System.out.println(r.toString());
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<AjaxDx> queryByCodeAlaxDx(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AjaxDx>  list = new ArrayList<AjaxDx>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 
				
			sql.append("SELECT MAX(T.score) value,T.name");
			sql.append(" FROM exercise_result T");
			sql.append(" WHERE T.user_code = '").append(usercode);
			sql.append("' AND T.TYPE = 1");
		    sql.append(" GROUP BY T.name");
//		    System.out.println(sql.toString());
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				AjaxDx r = new AjaxDx();
				
				r.setValue(rs.getString(1));
				r.setName(rs.getString(2));
				
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<AjaxPd> queryByCodeAlaxPd(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AjaxPd>  list = new ArrayList<AjaxPd>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 
				
			sql.append("SELECT MAX(T.score) value,T.name");
			sql.append(" FROM exercise_result T");
			sql.append(" WHERE T.user_code = '").append(usercode);
			sql.append("' AND T.TYPE = 2");
		    sql.append(" GROUP BY T.name");
//		    System.out.println(sql.toString());
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				AjaxPd r = new AjaxPd();
				
				r.setValue(rs.getString(1));
				r.setName(rs.getString(2));
				
				list.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	// 根据id来删除数据
	public void delete(int id) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "DELETE FROM exercise_result WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	

}


