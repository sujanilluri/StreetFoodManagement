package com.sfm.bean;

public class Cart {
	private int orid;
	private String shopName;
	private String shopAdd;
	private String itemName;
	private double itemPrice;
	private int qty;
	private double total;
	private String uname;
	private String uadd;
	public Cart(int orid,String shopName, String shopAdd, String itemName, double itemPrice, int qty, double total, String uname,
			String uadd) {
		super();
		this.orid=orid;
		this.shopName = shopName;
		this.shopAdd = shopAdd;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.qty = qty;
		this.total = total;
		this.uname = uname;
		this.uadd = uadd;
	}
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAdd() {
		return shopAdd;
	}
	public void setShopAdd(String shopAdd) {
		this.shopAdd = shopAdd;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUadd() {
		return uadd;
	}
	public void setUadd(String uadd) {
		this.uadd = uadd;
	}
	
	
	
	

}
