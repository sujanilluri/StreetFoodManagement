package com.sfm.dao;

import java.util.List;

import com.sfm.bean.Cart;
import com.sfm.bean.Shops;

public interface UserDao {
	public Shops viewshops(int sno);
	public List<Shops>viewallshops();
	public List<Shops> viewshops(String name);
	public int AddCart(int orid,String shopName, String shopAdd, String itemName, double itemPrice,int qty,double total,String uname,String uadd); 
	public List<Cart> ViewCart();
	public Shops shopItem(int item);
	public int deleteCart(int no);
	
}
