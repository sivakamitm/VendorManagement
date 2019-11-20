package com.ust.dao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.LoginBean;

public class LoginDao implements ILoginDao {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//select the userid for matching username and password
	/* (non-Javadoc)
	 * @see com.ust.dao.ILoginDao#verifyUserLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public LoginBean verifyUserLogin(String uname, String pass) {
		LoginBean loginBean= new LoginBean();
		String sql = "select userId,userName,password from Login where userName = ? and password=? ";
		 loginBean= template.queryForObject(sql,
					new Object[] { uname, pass },
					new BeanPropertyRowMapper<LoginBean>(LoginBean.class));
		 return loginBean;
		
	}
}
