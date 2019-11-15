package com.sfm.dao;

import java.util.List;

import com.sfm.bean.Shops;

public interface AdminDao {
	
	
public List<Shops> viewShop(int sno);
public List<Shops> viewAllShops();
public int updateShop(String shopName,String shopAdd,Long Contact,String email,String venName,Long mobile,int sno);
public int deleteShop(int pid);
public Shops viewShop1(int sno);
	

}
