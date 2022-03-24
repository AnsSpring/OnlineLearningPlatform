package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.Admin;
import com.entity.LoginUser;


public class AdminDBHelp {
	
	
	 // 根据id来修改数据
	public void modify(Admin a) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE admin SET username ='").append(a.getUsername());
			sql.append("',password='").append(a.getPassword());
			sql.append("',role='").append(a.getRole());
			sql.append("',real_name='").append(a.getRealName());
			sql.append("',class_and_grade='").append(a.getClassAndGrade());
			sql.append("',age='").append(a.getAge());
			sql.append("',sex='").append(a.getSex());
			sql.append("',mail='").append(a.getMail());
			sql.append("',phone='").append(a.getPhone());
			sql.append("',address='").append(a.getAddress());
			sql.append("'WHERE id = ").append(a.getId());


			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	
	 // 根据id来修改数据
	public void StudentModify(Admin a) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			
			//拼接sql
			sql.append("UPDATE admin SET password ='").append(a.getPassword());
//			sql.append("',password='").append(a.getPassword());
//			sql.append("',real_name='").append(a.getRealName());
//			sql.append("',class_and_grade='").append(a.getClassAndGrade());
//			sql.append("',age='").append(a.getAge());
//			sql.append("',sex='").append(a.getSex());
			sql.append("',mail='").append(a.getMail());
			sql.append("',phone='").append(a.getPhone());
			sql.append("',address='").append(a.getAddress());
			sql.append("'WHERE id = ").append(a.getId());


			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
    //插入数据
	public void update(Admin admin) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO admin(usercode,username,password,role,create_by,create_time,real_name,class_and_grade,sex,age,mail,phone,address) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, admin.getUsercode());
			preparedStatement.setString(2, admin.getUsername());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, admin.getRole());
			preparedStatement.setString(5, admin.getCreateBy());
			preparedStatement.setString(6, admin.getCreateTime());
			preparedStatement.setString(7, admin.getRealName());
			preparedStatement.setString(8, admin.getClassAndGrade());
			preparedStatement.setString(9, admin.getSex());
			preparedStatement.setString(10, admin.getAge());
			preparedStatement.setString(11, admin.getMail());
			preparedStatement.setString(12, admin.getPhone());
			preparedStatement.setString(13, admin.getAddress());

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

			String sql = "DELETE FROM admin WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}

    
	//查询数据
	public ArrayList<Admin> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Admin>  list = new ArrayList<Admin>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 

//			String sql = " SELECT id,username,password " + "FROM admin";
			
			sql.append("SELECT T.id,T.usercode,T.username,T.password,");
			sql.append("(CASE role WHEN 1 THEN '管理员' WHEN 2 THEN '教师' ELSE '学生' END) AS 'role',");
			sql.append("T.real_name,T.class_and_grade,");
			sql.append("(CASE sex WHEN 1 THEN '男' WHEN 2 THEN '女' ELSE '未知' END) AS 'sex',");
			sql.append("T.age,T.mail,T.phone,T.address,T.create_by,T.create_time");
			sql.append(" FROM admin T");

			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				Admin admin = new Admin();
				
				admin.setId(rs.getInt(1));
				admin.setUsercode(rs.getString(2));
				admin.setUsername(rs.getString(3));
				admin.setPassword(rs.getString(4));
				admin.setRole(rs.getString(5));
				admin.setRealName(rs.getString(6));
				admin.setClassAndGrade(rs.getString(7));
				admin.setSex(rs.getString(8));
				admin.setAge(rs.getString(9));
				admin.setMail(rs.getString(10));
				admin.setPhone(rs.getString(11));
				admin.setAddress(rs.getString(12));
				admin.setCreateBy(rs.getString(13));
				admin.setCreateTime(rs.getString(14));

				list.add(admin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据，学生和教师的数据
	public ArrayList<Admin> queryByUser() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Admin>  list = new ArrayList<Admin>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 

//			String sql = " SELECT id,username,password " + "FROM admin";
			
			sql.append("SELECT T.id,T.usercode,T.username,T.password,");
			sql.append("(CASE role WHEN 1 THEN '管理员' WHEN 2 THEN '教师' ELSE '学生' END) AS 'role',");
			sql.append("T.real_name,T.class_and_grade,");
			sql.append("(CASE sex WHEN 1 THEN '男' WHEN 2 THEN '女' ELSE '未知' END) AS 'sex',");
			sql.append("T.age,T.mail,T.phone,T.address,T.create_by,T.create_time");
			sql.append(" FROM admin T");
			sql.append(" WHERE T.role in (2,3)");

			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				Admin admin = new Admin();
				
				admin.setId(rs.getInt(1));
				admin.setUsercode(rs.getString(2));
				admin.setUsername(rs.getString(3));
				admin.setPassword(rs.getString(4));
				admin.setRole(rs.getString(5));
				admin.setRealName(rs.getString(6));
				admin.setClassAndGrade(rs.getString(7));
				admin.setSex(rs.getString(8));
				admin.setAge(rs.getString(9));
				admin.setMail(rs.getString(10));
				admin.setPhone(rs.getString(11));
				admin.setAddress(rs.getString(12));
				admin.setCreateBy(rs.getString(13));
				admin.setCreateTime(rs.getString(14));

				list.add(admin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	//查询数据
	public ArrayList<Admin> queryStudent() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Admin>  list = new ArrayList<Admin>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 
			
			sql.append("SELECT T.id,T.usercode,T.username,T.password,");
			sql.append("(CASE role WHEN 1 THEN '管理员' WHEN 2 THEN '教师' ELSE '学生' END) AS 'role',");
			sql.append("T.real_name,T.class_and_grade,");
			sql.append("(CASE sex WHEN 1 THEN '男' WHEN 2 THEN '女' ELSE '未知' END) AS 'sex',");
			sql.append("T.age,T.mail,T.phone,T.address,T.create_by,T.create_time");
			sql.append(" FROM admin T");
			sql.append(" WHERE T.role = 3");

			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {

				Admin admin = new Admin();
				
				admin.setId(rs.getInt(1));
				admin.setUsercode(rs.getString(2));
				admin.setUsername(rs.getString(3));
				admin.setPassword(rs.getString(4));
				admin.setRole(rs.getString(5));
				admin.setRealName(rs.getString(6));
				admin.setClassAndGrade(rs.getString(7));
				admin.setSex(rs.getString(8));
				admin.setAge(rs.getString(9));
				admin.setMail(rs.getString(10));
				admin.setPhone(rs.getString(11));
				admin.setAddress(rs.getString(12));
				admin.setCreateBy(rs.getString(13));
				admin.setCreateTime(rs.getString(14));

				list.add(admin);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}
	
	
	//查询登录用户的角色相关信息
	public LoginUser queryLoginInfo(String username) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		LoginUser  lu = new LoginUser();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			StringBuffer sql = new StringBuffer(); 

			
			sql.append("SELECT T.id,T.usercode,T.role,T.real_name,T.username,");
			sql.append("(CASE role WHEN 1 THEN '管理员' WHEN 2 THEN '教师' ELSE '学生' END) AS role_value");
			sql.append(" FROM admin T");
			sql.append(" WHERE T.username = '").append(username);
			sql.append("' ORDER BY T.ID DESC LIMIT 1");
		
//            log.info(sql.toString());
			
			System.out.println(sql.toString());
            
			rs = statement.executeQuery(sql.toString());

			while (rs.next()) {
				
				lu.setId(rs.getInt(1));
				lu.setUsercode(rs.getString(2));
				lu.setRole(rs.getInt(3));
				lu.setRealName(rs.getString(4));
				lu.setUsername(rs.getString(5));
				lu.setRoleValue(rs.getString(6));
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return lu;
	}

}


