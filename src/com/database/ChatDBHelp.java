package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.AjaxChat;
import com.entity.Chat;
import com.entity.ChatTotal;


public class ChatDBHelp {
	
	// 根据id来修改数据
	public void modifyCheck(Chat c) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "UPDATE chat SET is_check ='" + c.getIsCheck()
					+ "'WHERE id = "+ c.getId();
			
			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	 // 根据id来修改数据
	public void modify(Chat c) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE chat SET advice ='").append(c.getAdvice());
			sql.append("',usercode='").append(c.getUsercode());
			sql.append("',username='").append(c.getUsername());
			sql.append("'WHERE id = ").append(c.getId());


			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
    //插入数据
	public void update(Chat c) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO chat(code,name,usercode,username,advice,is_check,create_time) ");
			sql.append("VALUES(?,?,?,?,?,?,?)");
			

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, c.getCode());
			preparedStatement.setString(2, c.getName());
			preparedStatement.setString(3, c.getUsercode());
			preparedStatement.setString(4, c.getUsername());
			preparedStatement.setString(5, c.getAdvice());
			preparedStatement.setString(6, c.getIsCheck());
			preparedStatement.setString(7, c.getCreateTime());

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

			String sql = "DELETE FROM chat WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

    
	//查询数据
	public ArrayList<Chat> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Chat>  list = new ArrayList<Chat>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			
			String sql = " SELECT id,code,name,usercode,username,advice,create_time,"
				         + " (CASE is_check WHEN 0 THEN '未同意' WHEN 1 THEN '已同意' END ) AS is_check "
				         + " FROM chat T";
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				Chat c = new Chat();
				
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setName(rs.getString(3));
				c.setUsercode(rs.getString(4));
				c.setUsername(rs.getString(5));
				c.setAdvice(rs.getString(6));
				c.setCreateTime(rs.getString(7));
				c.setIsCheck(rs.getString(8));
				

				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	  
	//查询数据
	public ArrayList<ChatTotal> queryTotalInfo() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<ChatTotal>  list = new ArrayList<ChatTotal>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			
			String sql = "SELECT max(T.id) id,count(T.id) total,T.code,T.name " +
					" FROM chat T " +
					" WHERE T.is_check = 1" +
					" GROUP BY T.code,T.name " +
					" ORDER BY id";
					
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				ChatTotal ct = new ChatTotal();
				
				ct.setId(rs.getInt(1));
				ct.setTotal(rs.getString(2));
				ct.setCode(rs.getString(3));
				ct.setName(rs.getString(4));
		
				list.add(ct);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<AjaxChat> queryAjaxInfo() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AjaxChat>  list = new ArrayList<AjaxChat>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			
			String sql = "SELECT count(T.id) value,T.name FROM chat T GROUP BY T.name";
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				AjaxChat ct = new AjaxChat();
				
				ct.setValue(rs.getString(1));
				ct.setName(rs.getString(2));
		
				list.add(ct);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	//查询数据
	public ArrayList<Chat> queryByCode(String code) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Chat>  list = new ArrayList<Chat>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			
			String sql = " SELECT T.* FROM chat T WHERE T.code =" + code;
			
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				Chat c = new Chat();
				
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setName(rs.getString(3));
				c.setUsercode(rs.getString(4));
				c.setUsername(rs.getString(5));
				c.setAdvice(rs.getString(6));
				c.setCreateTime(rs.getString(7));
				

				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	


}


