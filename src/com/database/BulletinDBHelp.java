package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.Bulletin;


public class BulletinDBHelp {
	
	//插入一条公告信息
	public void update(Bulletin bulletin) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "INSERT INTO bulletin(topic,content,is_check,create_time)" + "VALUES(?,?,?,?)";

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.setString(1, bulletin.getTopic());
			preparedStatement.setString(2, bulletin.getContent());
			preparedStatement.setString(3, bulletin.getIsCheck());
			preparedStatement.setString(4, bulletin.getCreateTime());

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

			String sql = "DELETE FROM bulletin WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

	// 根据id来修改数据
	public void modify(Bulletin bulletin) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "UPDATE bulletin SET topic ='" + bulletin.getTopic()
				    + "',content='" + bulletin.getContent()
				    + "',is_check='" + bulletin.getIsCheck()
					+ "'WHERE id = "+ bulletin.getId();
			
			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	// 根据id来修改数据
	public void modifyIsCheck(Bulletin bulletin) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "UPDATE bulletin SET topic ='" + bulletin.getTopic()
				    + "',content='" + bulletin.getContent()
					+ "'WHERE id = "+ bulletin.getId();
			
			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	// 查询数据
	public ArrayList<Bulletin> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Bulletin> list = new ArrayList<Bulletin>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();

			String sql = " SELECT id,topic,content,create_time, "
				    + "(CASE is_check WHEN 0 THEN '未审核' WHEN 1 THEN '已审核' END ) AS is_check "
					+ "FROM bulletin";

			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Bulletin bulletin = new Bulletin();

				bulletin.setId(rs.getInt(1));
				bulletin.setTopic(rs.getString(2));
				bulletin.setContent(rs.getString(3));
				bulletin.setCreateTime(rs.getString(4));
				bulletin.setIsCheck(rs.getString(5));

				list.add(bulletin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	// 查询数据
	public ArrayList<Bulletin> queryIsCheck() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Bulletin> list = new ArrayList<Bulletin>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();

			String sql = " SELECT id,topic,content,create_time, "
				    + "(CASE is_check WHEN 0 THEN '未审核' WHEN 1 THEN '已审核' END ) AS is_check "
					+ " FROM bulletin "
                    + " WHERE is_check = 1";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Bulletin bulletin = new Bulletin();

				bulletin.setId(rs.getInt(1));
				bulletin.setTopic(rs.getString(2));
				bulletin.setContent(rs.getString(3));
				bulletin.setCreateTime(rs.getString(4));
				bulletin.setIsCheck(rs.getString(5));

				list.add(bulletin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}

}
