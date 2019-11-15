package com.sfm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sfm.bean.Cart;
import com.sfm.dao.DeliveryDao;
import com.sfm.utility.ConnectionManager;

public class DeliveryDaoImpl implements DeliveryDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private static final Logger logger=LogManager.getLogger(DeliveryDaoImpl.class);

	@Override
	public List<Cart> viewOrders() {
		List<Cart> or=new ArrayList<Cart>();
		
		 try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement("select * from sfm.order");
				rs=ps.executeQuery();
				while(rs.next())
				{
					Cart c=new Cart(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
					or.add(c);
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
			return or;
		}
		
		
	

}
