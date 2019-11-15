package com.sfm.dao;

import com.sfm.bean.Register;

public interface LoginDao {
	public int RegisterImpl(Register v);
	public boolean login(String vemail, String vpwd);
	public int forgotpwd(String vemail, String p);

}
