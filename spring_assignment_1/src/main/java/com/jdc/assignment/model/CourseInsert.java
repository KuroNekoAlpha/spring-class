/**
 * 
 */
package com.jdc.assignment.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * @author OAK SOE KHANT
 *
 */
public class CourseInsert {
	private DataSource datasource;
		private static final String SQL="insert into course (name,fee,duration) values (?,?,?)";
	
	
		public CourseInsert(DataSource datasource) {
			this.datasource=datasource;
		}


	public void insert(Course c) {
		try(var conn=datasource.getConnection()){
			var stmt=conn.prepareStatement(SQL);
			stmt.setString(1, c.getName());
			stmt.setInt(2, c.getFee());
			stmt.setInt(3, c.getDuration());
			stmt.executeUpdate();
		}catch (SQLException e) {
		e.printStackTrace();
		}
	}
}
