package com.sfm.bean;

public class Shops {
	

	private int sno;
	private String shopName;
	private String shopAdd;
	private long contact;
	private String email;
	private int venId;
	private String venName;
	private int age;
	private String gender;
	private long mobile;
	private int itemno;
	private String itemName;
	private double itemPrice;
	private String type;
	
	
	
	public Shops(int sno, String shopName, String shopAdd, long contact, String email, int venId, String venName,
			int age, String gender, Long mobile, int itemno, String itemName, double itemPrice,String type) {
		super();
		this.sno = sno;
		this.shopName = shopName;
		this.shopAdd = shopAdd;
		this.contact = contact;
		this.email = email;
		this.venId = venId;
		this.venName = venName;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
		this.itemno =itemno;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.type =type;
		
		
	}

	public int getItemno() {
		return itemno;
	}



	public void setItemno(int itemno) {
		this.itemno = itemno;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Shops() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getSno() {
		return sno;
	}



	public void setSno(int sno) {
		this.sno = sno;
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



	public long getContact() {
		return contact;
	}



	public void setContact(long contact) {
		this.contact = contact;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getVenId() {
		return venId;
	}



	public void setVenId(int venId) {
		this.venId = venId;
	}



	public String getVenName() {
		return venName;
	}



	public void setVenName(String venName) {
		this.venName = venName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Long getMobile() {
		return mobile;
	}



	public void setMobile(Long mobile) {
		this.mobile = mobile;
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
	
	
	
	@Override
	public String toString() {
		return "Shops [sno=" + sno + ", shopName=" + shopName + ", shopAdd=" + shopAdd + ", cotnact=" + contact
				+ ", email=" + email + ", venId=" + venId + ", venName=" + venName + ", age=" + age + ", gender="
				+ gender + ", mobile=" + mobile + ", itemno=" + itemno + ", itemName=" + itemName + ", itemPrice="
				+ itemPrice + ", type=" + type + "]";
	}


	
	
}
