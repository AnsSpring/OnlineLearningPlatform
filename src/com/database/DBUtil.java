package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.entity.Person;

public class DBUtil {
	
	// ²éÑ¯Êý¾Ý
	public static ArrayList<Person> query() {

		Connection coon = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Person> list = new ArrayList<Person>();

		try {
			coon = DBOpenClose.openConnection();

			statement = coon.createStatement();
			
			String sql = " SELECT DISTINCT m.id,g.id,e.flag,m.username,m.number,m.address,g.name,g.price,e.mygood,e.did "
			            + " FROM member m,exchange e,goods g"
			            + " WHERE m.id = e.mid "
			            + " AND e.gid = g.id "
			            + " ORDER BY e.gid";

			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Person p = new Person();
				
				p.setId(rs.getInt(1));
				p.setGid(rs.getInt(2));
		        p.setFlag(rs.getString(3));
		        p.setUsername(rs.getString(4));
		        p.setNumber(rs.getString(5));
		        p.setAddress(rs.getString(6));
		        p.setName(rs.getString(7));
		        p.setPrice(rs.getString(8));
		        p.setMygood(rs.getString(9));
		        p.setDid(rs.getInt(10));
				
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBOpenClose.release(rs, coon, statement);
		}

		return list;
	}


}
