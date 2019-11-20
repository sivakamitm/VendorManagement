package com.ust.dao;

import com.ust.model.LoginBean;

public interface ILoginDao {

	//select the userid for matching username and password
	public abstract LoginBean verifyUserLogin(String uname, String pass);

}