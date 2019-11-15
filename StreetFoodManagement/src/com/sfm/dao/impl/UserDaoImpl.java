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

import com.sfm.bean.Cart;
import com.sfm.bean.Shops;
import com.sfm.dao.UserDao;
import com.sfm.utility.ConnectionManager;

public class UserDaoImpl implements UserDao {
	Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;
	private static final Logger logger=LogManager.getLogger(LoginDaoImpl.class);
	public static List<Cart> cartitem=new ArrayList<Cart>();
	
	
	@Override
	public Shops viewshops(int sno) {
		Shops s=null;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from shops where sno=?");
			ps.setInt(1,sno);
			rs=ps.executeQuery();
			while(rs.next())
			{
				 s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
				
			}
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
		return s;
	}

	@Override
	public List<Shops> viewallshops() {
		 List<Shops>AllShops=new ArrayList<Shops>();
		 try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from shops");
			rs=ps.executeQuery();
			while(rs.next()){
				Shops s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			AllShops.add(s);			}
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
		return AllShops;
	}

	@Override
	public List<Shops> viewshops(String name) {
		// TODO Auto-generated method stub
		List<Shops> shop1=new ArrayList<Shops>();
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from shops where shopName=?");
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()){
				 Shops s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
				 shop1.add(s);
			}
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

		return shop1;
		
	}

	@Override
	public int AddCart(int orid,String shopName, String shopAdd, String itemName, double itemPrice,int qty,double total,String uname,String uadd) {
		int status=0;
		Scanner sc=new Scanner(System.in);
try {
	
	con=ConnectionManager.getConnection();
	ps=con.prepareStatement("insert into sfm.order(orid,shopName,shopAdd,itemName,itemPrice,qty,total,uname,uadd) values(?,?,?,?,?,?,?,?,?)");
	
	
	ps.setInt(1,orid);
	ps.setString(2, shopName);
	ps.setString(3,shopAdd);
	ps.setString(4,itemName);
	ps.setDouble(5,itemPrice);
	ps.setInt(6,qty);
	ps.setDouble(7,total);
	ps.setString(8,uname);
	ps.setString(9,uadd);
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
		public List ViewCart()
		{
			List<Cart> temp=new ArrayList<Cart>();
			if(cartitem!=null)
			{
				for(Cart rs:cartitem)
				{
					Cart s=new Cart(rs.getOrid(),rs.getShopName(),rs.getShopAdd(),rs.getItemName(),rs.getItemPrice(),rs.getQty(),rs.getTotal(),rs.getUname(),rs.getUadd());
				temp.add(s);
				}
			}
			else
			{
				System.out.println("empty cart");
			}
			return temp;
		}
		
		public Shops shopItem(int item)
		{
			Shops s=null;
			
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement("select * from shops where itemno=?");
				ps.setInt(1,item);
				rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getString(7)+"\t"+rs.getInt(8)+"\t"+rs.getString(9)+"\t"+rs.getLong(10)+"\t"+rs.getInt(11)+"\t"+rs.getString(12)+"\t"+rs.getDouble(13)+"\t"+rs.getString(14));
					 s=new Shops(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getLong(10),rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
					
				}
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
			return s;
		}
		public int getorid()
		{
			int id=0;
			
				try {
					con=ConnectionManager.getConnection();
					ps=con.prepareStatement("SELECT MAX(orid) FROM sfm.order;");
					System.out.println("orderid checking");
					rs=ps.executeQuery();
					if(rs.next())
					{
						id=rs.getInt(1);
						System.out.println(id);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					logger.error(e);
					e.printStackTrace();
				}
			
			return id;
			
		}
		
		public int deleteCart(int no)
		{
			
			int k=0;
			for(Cart sd:cartitem)
			{
				if(sd.getOrid()==no)
				{
					k++;
					cartitem.remove(sd);	
					System.out.println("student record is deleted");
					logger.info("student record is deleted");
				}
				
			}
			if(k==0)
			{
				System.out.println("student record not available");
				logger.info("student record not available");
			}
			return k;
			
		}
		
		
		
		
	}
	

