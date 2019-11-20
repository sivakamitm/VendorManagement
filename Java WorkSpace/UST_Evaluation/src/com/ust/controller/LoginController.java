package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.ILoginDao;
import com.ust.model.LoginBean;

@RestController
@RequestMapping("/ust")
public class LoginController {
	
	@Autowired
	ILoginDao loginDao;
	@RequestMapping(value = "/{uname}/{pass}", method = RequestMethod.GET)
	public LoginBean verifyLogin(@PathVariable("uname") String uname,
			@PathVariable("pass") String pass) {
		return loginDao.verifyUserLogin(uname, pass);
	}
}
