package com.sfm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.Cookie;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sfm.bean.Shops;
import com.sfm.dao.VendorDao;
import com.sfm.utility.ConnectionManager;


public class VendorDaoImpl implements VendorDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private static final Logger logger=LogManager.getLogger(VendorDaoImpl.class);
	Scanner sc=new Scanner(System.in);
	
	

	@Override
	public int addShop(Shops sh) {
		int count=0;
		try {
			con=	ConnectionManager.getConnection();
		ps=con.prepareStatement("insert into shops values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,sh.getSno());
		ps.setString(2,sh.getShopName());
		ps.setString(3,sh.getShopAdd());
		ps.setLong(4,sh.getContact());
		ps.setString(5,sh.getEmail());
		ps.setInt(6,sh.getVenId());
		ps.setString(7,sh.getVenName());
		ps.setInt(8,sh.getAge());
		ps.setString(9,sh.getGender());
		ps.setLong(10,sh.getMobile());
		ps.setInt(11,sh.getItemno());
		ps.setString(12,sh.getItemName());
		ps.setDouble(13,sh.getItemPrice());
		ps.setString(14,sh.getType());
		 count=ps.executeUpdate();
			
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
	public List<Shops> viewAllShops(String email) {
		 List<Shops>shop=new ArrayList<Shops>();
		 try {
			 
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from shops where email=?");
			ps.setString(1,email);
			rs=ps.executeQuery();
			while(rs.next()){
				Shops  s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
				shop.add(s);			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		 finally{
			 try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
		 }
		return shop;
	}

	@Override
	public Shops viewShop(int sno) {
		// TODO Auto-generated method stub
		Shops s=null;
		try {
			con=ConnectionManager.getConnection();
			 ps=con.prepareStatement("select * from shops where itemno=?");
			 ps.setInt(1,sno);
			rs= ps.executeQuery();
			 while(rs.next())
			 {
				 s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
		}
		return s;
	}

	@Override
	public int updateShop(int venId, String venName, String age, String gender, Long mobile, String itemName, double itemPrice, String type,
			int itemno) {
		int status=0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("update shops set venId=?,venName=?,age=?,gender=?,mobile=?,itemName=?,itemprice=?,type=? where itemno=?");
			ps.setInt(1, venId);
			ps.setString(2, venName);
			ps.setString(3,age);
			ps.setString(4,gender);
			ps.setLong(5,mobile);
			ps.setString(6,itemName);
			ps.setDouble(7,itemPrice);
			ps.setString(8,type);
			ps.setInt(9,itemno);
			status=ps.executeUpdate();
			if(status!=0){
				System.out.println("updated");
				logger.info("updated");
			}
			else
			{
				System.out.println("not updated");
				logger.info("not updated");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}

			return status;

			
	}
	@Override
	public int deleteShop(int itemno) {
		int status=0;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from shops where itemno=?");
			ps.setInt(1, itemno);
			status=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return status;
		
	}

	
	

}
