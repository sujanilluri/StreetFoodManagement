package com.sfm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sfm.bean.Register;
import com.sfm.dao.LoginDao;
import com.sfm.utility.ConnectionManager;

public class LoginDaoImpl implements LoginDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private static final Logger logger=LogManager.getLogger(LoginDaoImpl.class);
	Scanner sc=new Scanner(System.in);
	public static String type;

	@Override
	public int RegisterImpl(Register v) {
		int count=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("insert into login values(?,?,?,?,?)");
			ps.setInt(1, v.getSno());
			ps.setString(2, v.getName());
			ps.setString(3,v.getEmail());
			ps.setString(4, v.getPwd());
			ps.setString(5, v.getType());
			count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("Data inserted");
			}
			else
			{
				System.out.println("Data not inserted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
		
	
	finally
	{
		try {
			ConnectionManager.release(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
	}
	return count;
	}

	@Override
	public boolean login(String email, String pwd) {

		boolean flag=false;
		Register r=null;

		System.out.println(email+"\t"+pwd);
		
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement("select * from login where email=? and pwd=?");
				ps.setString(1, email);
				ps.setString(2, pwd);
				rs=ps.executeQuery();
				if(rs.next())
				{
					r=new Register(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
					type=rs.getString(5);
					
					flag=true;
				}
				else 
				{
					System.out.println("not a valid user");
				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
					
			
		
		
		
		return flag;
	}

	@Override
	public int forgotpwd(String email ,String p) {
		int status=0;
		try {
			con=ConnectionManager.getConnection();
			//System.out.println("Enter new pass");
			//String p=sc.next();
			ps=con.prepareStatement("update login  set pwd=? where email=?");
			ps.setString(1,p);
			ps.setString(2,email);
			status=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		if(status!=0)
		{
			System.out.println("password updated");
		}
		else {
			System.out.println("email not valid");
		}
		return status;
	}

}
