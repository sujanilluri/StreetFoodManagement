package com.sfm.dao;

import java.util.List;

import com.sfm.bean.Shops;
import com.sfm.bean.Register;

public interface VendorDao {
	
	public int addShop(Shops sh);
	public List<Shops>viewAllShops(String email);
	public Shops viewShop(int sno);
	public int updateShop(int venId, String venName, String age, String gender, Long mobile, String itemName, double itemPrice, String type,
			int itemno);
	public int deleteShop(int sno);
	
	
	

}
