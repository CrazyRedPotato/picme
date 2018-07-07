package com.picme.service;

import com.picme.pojo.User;

public interface UserService {
	String login(User user, String pwd);
	String registered(User user);
	User creatPwdMsg(User user, String pwd);	
	boolean registerChkMail(String mail);
}
