package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.CodeName;
import com.entity.Project;
import com.entity.ProjectCount;


public class ProjectDBHelp {
	
	 // 根据id来修改数据
	public void modify(Project p) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE subject SET name ='").append(p.getName());
			sql.append("',content='").append(p.getContent());
			sql.append("'WHERE id = ").append(p.getId());


			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
    //插入数据
	public void update(Project p) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO subject(code,usercode,name,content,create_time) ");
			sql.append("VALUES(?,?,?,?,?)");

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, p.getCode());
			preparedStatement.setString(2, p.getUsercode());
			preparedStatement.setString(3, p.getName());
			preparedStatement.setString(4, p.getContent());
			preparedStatement.setString(5, p.getCreateTime());
			

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

			String sql = "DELETE FROM subject WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

    
	//查询数据
	public ArrayList<Project> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Project>  list = new ArrayList<Project>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = " SELECT T.id,T.code,T.usercode,T.name,T.content,T.create_time,A.real_name teacherName"
				         +" FROM subject T"
				         + " JOIN admin A ON A.usercode = T.usercode" 
				         +	" ORDER BY T.create_time ASC";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Project p = new Project();
				
				p.setId(rs.getInt(1));
				p.setCode(rs.getString(2));
				p.setUsercode(rs.getString(3));
				p.setName(rs.getString(4));
				p.setContent(rs.getString(5));
				p.setCreateTime(rs.getString(6));
				p.setTeacherName(rs.getString(7));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<Project> queryByUsercode(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Project>  list = new ArrayList<Project>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = " SELECT T.id,T.code,T.usercode,T.name,T.content,T.create_time,A.real_name teacherName"
				         +" FROM subject T"
				         + " JOIN admin A ON A.usercode = T.usercode" 
				         + " where T.usercode=" + usercode
				         +	" ORDER BY T.create_time ASC";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Project p = new Project();
				
				p.setId(rs.getInt(1));
				p.setCode(rs.getString(2));
				p.setUsercode(rs.getString(3));
				p.setName(rs.getString(4));
				p.setContent(rs.getString(5));
				p.setCreateTime(rs.getString(6));
				p.setTeacherName(rs.getString(7));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<CodeName> queryCodeAndName() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<CodeName>  list = new ArrayList<CodeName>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = " SELECT T.code,T.name " + " FROM subject T";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				CodeName cn = new CodeName();
				
				cn.setCode(rs.getString(1));
				cn.setName(rs.getString(2));

				list.add(cn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	//数据统计
	public ArrayList<ProjectCount> queryProjectCount(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		
		//单选题
		ArrayList<ProjectCount>  scList = new ArrayList<ProjectCount>();
		
		//判断题
		ArrayList<ProjectCount>  jqList = new ArrayList<ProjectCount>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = " SELECT MAX(T.ID) id,T.CODE,T.NAME,COUNT(A.ID) SC_COUNT  FROM subject T"+
                         " LEFT JOIN single_choice A ON T.CODE = A.PCODE" +
                         " JOIN course_result B ON T.CODE = B.CODE" +
                         " WHERE B.user_code =" + usercode +
                         " GROUP BY T.CODE,T.NAME" +
                         " ORDER BY T.CODE";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				ProjectCount cn = new ProjectCount();
				
				cn.setId(rs.getInt(1));
				cn.setCode(rs.getString(2));
				cn.setName(rs.getString(3));
				cn.setScCount(rs.getString(4));

				scList.add(cn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}
		
		
		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = " SELECT MAX(T.ID) id,T.CODE,T.NAME,COUNT(A.ID) SC_COUNT  FROM subject T"+
                         " LEFT JOIN judge_question A ON T.CODE = A.PCODE" +
                         " JOIN course_result B ON T.CODE = B.CODE" +
                         " WHERE B.user_code =" + usercode +
                         " GROUP BY T.CODE,T.NAME" +
                         " ORDER BY T.CODE";;
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				ProjectCount cn = new ProjectCount();
				
				cn.setId(rs.getInt(1));
				cn.setCode(rs.getString(2));
				cn.setName(rs.getString(3));
				cn.setJqCount(rs.getString(4));

				jqList.add(cn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}
		
		for(int i = 0, len = scList.size(); i < len; i++){
			
			if(scList.get(i).getCode().equals(jqList.get(i).getCode())){
				
				scList.get(i).setJqCount(jqList.get(i).getJqCount());
			}
			
		}

		return scList;
	}
	
	
	

}


