package com.sfm.bean;

public class Register {
	private int sno;
	private String name;
	private String email;
	private String pwd;
	private String type;
	
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(int sno, String name, String email, String pwd, String type) {
		super();
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.type = type;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
	
	

}
