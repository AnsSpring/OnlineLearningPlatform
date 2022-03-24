package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.FileVo;


public class FileVoDBHelp {
	
	 // 根据id来修改数据
	public void modify(FileVo f) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE subject SET name ='").append(f.getName());
			sql.append("'WHERE id = ").append(f.getId());


			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
    //插入数据
	public void update(FileVo f) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO file(name,address,pcode,type,file_type,usercode,real_name,create_time) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?)");

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, f.getName());
			preparedStatement.setString(2, f.getAddress());
			preparedStatement.setString(3, f.getPcode());
			preparedStatement.setString(4, f.getType());
			preparedStatement.setString(5, f.getFileType());
			preparedStatement.setString(6, f.getUsercode());
			preparedStatement.setString(7, f.getRealName());
			preparedStatement.setString(8, f.getCreateTime());
			

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

			String sql = "DELETE FROM file WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

    
	//查询数据
	public ArrayList<FileVo> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<FileVo>  list = new ArrayList<FileVo>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.id,T.name,T.address,T.pcode,T.real_name,T.create_time,A.name pname," 
					     + "(CASE file_type WHEN 1 THEN '课件' WHEN 2 THEN '视频' ELSE '未知' END ) AS fileType" 
					     + " FROM file T JOIN subject A ON A.code = T.pcode"
					     + " ORDER BY T.create_time ASC";;
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				FileVo f = new FileVo();
				
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setAddress(rs.getString(3));
				f.setPcode(rs.getString(4));
				f.setRealName(rs.getString(5));
				f.setCreateTime(rs.getString(6));
				f.setPname(rs.getString(7));
				f.setFileType(rs.getString(8));
				

				list.add(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	//查询数据
	public ArrayList<FileVo> queryByCode(String usercode) {
		
		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<FileVo>  list = new ArrayList<FileVo>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.id,T.name,T.address,T.pcode,T.real_name,T.create_time,A.name pname," 
					     + "(CASE file_type WHEN 1 THEN '课件' WHEN 2 THEN '视频' ELSE '未知' END ) AS fileType" 
					     + " FROM file T JOIN subject A ON A.code = T.pcode"
					     + " WHERE T.usercode =" + usercode
					     + " ORDER BY T.create_time ASC";
			
//			System.out.println(sql);
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				FileVo f = new FileVo();
				
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setAddress(rs.getString(3));
				f.setPcode(rs.getString(4));
				f.setRealName(rs.getString(5));
				f.setCreateTime(rs.getString(6));
				f.setPname(rs.getString(7));
				f.setFileType(rs.getString(8));
				

				list.add(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;

	}
	
	//查询数据
	public ArrayList<FileVo> queryByType(String type) {
		
		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<FileVo>  list = new ArrayList<FileVo>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.id,T.name,T.address,T.pcode,T.real_name,T.create_time,A.name pname," 
					     + "(CASE file_type WHEN 1 THEN '课件' WHEN 2 THEN '视频' ELSE '未知' END ) AS fileType" 
					     + " FROM file T JOIN subject A ON A.code = T.pcode"
					     + " WHERE T.type =" + type
					     + " ORDER BY T.create_time ASC";
			
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				FileVo f = new FileVo();
				
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setAddress(rs.getString(3));
				f.setPcode(rs.getString(4));
				f.setRealName(rs.getString(5));
				f.setCreateTime(rs.getString(6));
				f.setPname(rs.getString(7));
				f.setFileType(rs.getString(8));
				

				list.add(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;

		
	}
	
	
	

}


