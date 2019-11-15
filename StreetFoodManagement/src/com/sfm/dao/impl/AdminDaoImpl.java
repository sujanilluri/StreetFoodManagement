package com.sfm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sfm.bean.Shops;
import com.sfm.dao.AdminDao;
import com.sfm.utility.ConnectionManager;

public class AdminDaoImpl implements AdminDao {
private static final Logger logger=LogManager.getLogger(AdminDaoImpl.class);
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<Shops> viewShop(int sno) {
		List<Shops>shop=new ArrayList<Shops>();
		try {
			con=ConnectionManager.getConnection();
			 ps=con.prepareStatement("select * from shops where sno=?");
			 ps.setInt(1,sno);
			rs= ps.executeQuery();
			 while(rs.next())
			 {
				 //System.out.println(s.getSno()+"\t"+s.getShopName()+"\t"+s.getShopAdd()+"\t"+s.getCotact()+"\t"+s.getEmail()+"\t"+s.getVenId()+"\t"+s.getVenName()+"\t"+s.getAge()+"\t"+s.getGender()+"\t"+s.getMobile()+"\t"+s.getItemno()+"\t"+s.getItemName()+"\t"+s.getItemPrice()+"\t"+s.getType());
				 Shops s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
				 shop.add(s);
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
       
		return shop;
		
	}

	
	
	public Shops viewShop1(int sno) {
		Shops s=null;
		try {
			con=ConnectionManager.getConnection();
			 ps=con.prepareStatement("select * from shops where sno=?");
			 ps.setInt(1,sno);
			rs= ps.executeQuery();
			 while(rs.next())
			 {
				 //System.out.println(s.getSno()+"\t"+s.getShopName()+"\t"+s.getShopAdd()+"\t"+s.getCotact()+"\t"+s.getEmail()+"\t"+s.getVenId()+"\t"+s.getVenName()+"\t"+s.getAge()+"\t"+s.getGender()+"\t"+s.getMobile()+"\t"+s.getItemno()+"\t"+s.getItemName()+"\t"+s.getItemPrice()+"\t"+s.getType());
				  s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
				 
			 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
       
		return s;
		
	}
	
	@Override
	public List<Shops> viewAllShops() {
		// TODO Auto-generated method stub
		 List<Shops>shop=new ArrayList<Shops>();
		 try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from shops");
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getString(7)+"\t"+rs.getInt(8)+"\t"+rs.getString(9)+"\t"+rs.getLong(10)+"\t"+rs.getInt(11)+"\t"+rs.getString(12)+"\t"+rs.getDouble(13)+"\t"+rs.getString(14));
				Shops s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			shop.add(s);			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return shop;
	}

	

	@Override
	public int deleteShop(int sno) {
		int status=0;
		Scanner sc=new Scanner(System.in);
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from shops where sno=?");
			ps.setInt(1, sno);
			status=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
		

	}

	@Override
	public int updateShop(String shopName, String shopAdd, Long Contact, String email, String venName, Long mobile,
			int sno) {
		int status=0;
		Scanner sc=new Scanner(System.in);
try {
	con=ConnectionManager.getConnection();
	ps=con.prepareStatement("update shops set shopName=?,shopAdd=?,contact=?,email=?,venName=?,mobile=? where sno=?");
	ps.setString(1, shopName);
	ps.setString(2,shopAdd);
	ps.setLong(3,Contact);
	ps.setString(4,email);
	ps.setString(5, venName);
	ps.setLong(6, mobile);
	ps.setInt(7,sno);
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
	e.printStackTrace();
}
return status;

	}

	

}
