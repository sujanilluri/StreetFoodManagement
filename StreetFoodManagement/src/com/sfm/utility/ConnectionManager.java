package com.sfm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sfm.dao.impl.AdminDaoImpl;

public class ConnectionManager {
	private static Connection con=null;
	private static final Logger logger=LogManager.getLogger(ConnectionManager.class);
	//user defined method
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Driver registred with DriverManager");
//Step 2: Establish Connection with Database S/w			
//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sfm","root","root");
		
System.out.println("Connection Interface Implementation Class :"+con);
logger.info("Connection Interface Implementation Class :");
if(con!=null)
System.out.println("Connection is established");
else
System.out.println("Connection is not established");
		
		return con;
	}
	
	
	public static void release(Connection con,PreparedStatement ps) throws SQLException
	{
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
	}
	
	public static void release(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException
	{
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
	}
}
