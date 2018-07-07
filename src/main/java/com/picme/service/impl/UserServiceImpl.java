package com.picme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picme.mapper.UserMapper;
import com.picme.pojo.User;
import com.picme.service.UserService;
import com.picme.utils.PwdProductor;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public String registered(User user) {
		try {
			userMapper.registered(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "注册失败";
		}
		
		return "注册成功";
	}

	@Override
	public User creatPwdMsg(User user, String pwd) {
		String pwdsalt = PwdProductor.getRandomSalt();
		user.setPwdsalt(pwdsalt);
		user.setPwdhash(PwdProductor.createPwdhash(pwdsalt, pwd));
		
		return user;
	}

	@Override
	public boolean registerChkMail(String mail) {
		User user = null;
		user = userMapper.getbymail(mail);
		 
		if (user == null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String login(User user, String pwd) {
		user = userMapper.getbymail(user.getMail());

		if (PwdProductor.checkPwdhash(user.getPwdsalt(), user.getPwdhash(), pwd)) {
			return "登陆成功";
		} else {
			return "登陆失败";
		}
	}
	
	
}
