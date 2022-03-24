package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.Course;
import com.entity.AjaxCourse;
import com.entity.SumCourse;


public class CourseDBHelp {
	
	
    //插入数据
	public void update(Course r) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO course_result(code,name,user_code,real_name,create_time) ");
			sql.append("VALUES(?,?,?,?,?)");

			preparedStatement = coon.prepareStatement(sql.toString());

			preparedStatement.setString(1, r.getCode());
			preparedStatement.setString(2, r.getName());
			preparedStatement.setString(3, r.getUsercode());
			preparedStatement.setString(4, r.getRealName());
			preparedStatement.setString(5, r.getCreateTime());
			

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	
	// 根据id来修改数据
	public void modify(Course c) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "UPDATE course_result SET is_check ='" + c.getIsCheck()
					+ "'WHERE id = "+ c.getId();
			
			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	

	//查询数据
	public ArrayList<Course> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Course>  list = new ArrayList<Course>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.id,T.code,T.name,T.user_code,T.real_name,T.create_time,"
				         +" (CASE is_check WHEN 0 THEN '未同意' WHEN 1 THEN '已同意' END ) AS is_check "
			             +" FROM course_result T";
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Course r = new Course();
				
				r.setId(rs.getInt(1));
				r.setCode(rs.getString(2));
				r.setName(rs.getString(3));
				r.setUsercode(rs.getString(4));
				r.setRealName(rs.getString(5));
				r.setCreateTime(rs.getString(6));
				r.setIsCheck(rs.getString(7));

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
	public ArrayList<SumCourse> queryByTeacherCode(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SumCourse>  list = new ArrayList<SumCourse>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.id,T.code,T.name,T.user_code,T.real_name,T.create_time,"
				         +" (CASE is_check WHEN 0 THEN '未同意' WHEN 1 THEN '已同意' END ) AS is_check, "
				         +" A.usercode teacherCode,B.real_name teacherName "
			             +" FROM course_result T JOIN subject A ON T.code = A.code JOIN admin B ON B.usercode = A.usercode" 
			             +" WHERE B.usercode=" +usercode;
			            
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				SumCourse sc = new SumCourse();
				
				sc.setId(rs.getInt(1));
				sc.setCode(rs.getString(2));
				sc.setName(rs.getString(3));
				sc.setUsercode(rs.getString(4));
				sc.setRealName(rs.getString(5));
				sc.setCreateTime(rs.getString(6));
				sc.setIsCheck(rs.getString(7));
				sc.setTeacherCode(rs.getString(8));
				sc.setTeacherName(rs.getString(9));

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
	public ArrayList<SumCourse> queryByStudentCode(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SumCourse>  list = new ArrayList<SumCourse>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.id,T.code,T.name,T.user_code,T.real_name,T.create_time,"
				         +" (CASE T.is_check WHEN 0 THEN '未同意' WHEN 1 THEN '已同意' END ) AS is_check, "
				         +" A.usercode teacherCode,B.real_name teacherName "
			             +" FROM course_result T JOIN subject A ON T.code = A.code JOIN admin B ON B.usercode = A.usercode" 
			             +" WHERE T.is_check = 1"
			             +" AND T.user_code=" +usercode;
			            
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				SumCourse sc = new SumCourse();
				
				sc.setId(rs.getInt(1));
				sc.setCode(rs.getString(2));
				sc.setName(rs.getString(3));
				sc.setUsercode(rs.getString(4));
				sc.setRealName(rs.getString(5));
				sc.setCreateTime(rs.getString(6));
				sc.setIsCheck(rs.getString(7));
				sc.setTeacherCode(rs.getString(8));
				sc.setTeacherName(rs.getString(9));

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
	public ArrayList<Course> queryByCode(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Course>  list = new ArrayList<Course>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.* "
				         +"FROM course_result T WHERE T.is_check = 1"
				         +" AND T.user_code = " + usercode;
			
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Course r = new Course();
				
				r.setId(rs.getInt(1));
				r.setCode(rs.getString(2));
				r.setName(rs.getString(3));
				r.setUsercode(rs.getString(4));
				r.setRealName(rs.getString(5));
				r.setCreateTime(rs.getString(6));

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
	public ArrayList<AjaxCourse> queryByUserCode(String usercode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AjaxCourse>  list = new ArrayList<AjaxCourse>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT T.code,T.name,0.0 n FROM course_result T WHERE T.user_code = '" + usercode + "'";
			
//			System.out.println(sql.toString());
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				AjaxCourse r = new AjaxCourse();
				
				r.setValue(rs.getString(1));
				r.setName(rs.getString(2));
				r.setN(rs.getDouble(3));

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
	public Integer getCourseIsExsit(String usercode,String pcode) {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;

		Integer count = 0;
		
		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			

			String sql = "SELECT COUNT(T.ID) FROM course_result T WHERE T.user_code = " + usercode + " AND T.CODE = " + pcode;
			
//			System.out.println(sql);
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {

				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return count;
	}
	
	
	
	
	
	// 根据id来删除数据
	public void delete(int id) throws SQLException {

		Connection coon = null;
		PreparedStatement preparedStatement = null;

		try {
			coon = DBOpenClose.openConnection();

			String sql = "DELETE FROM course_result WHERE id =" + id;

			preparedStatement = coon.prepareStatement(sql);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(null, coon, preparedStatement);

		}
	}
	

}


