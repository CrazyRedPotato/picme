package com.picme.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.picme.pojo.User;
import com.picme.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("usertest")
	public ModelAndView usertest() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping(value = "/test2/{uploadtype}", method = RequestMethod.GET, produces="text/json;charset=UTF-8")
	public ResponseEntity<User> test(@PathVariable Integer uploadtype) {
		String msg = "你好 hello" + uploadtype;
		User user = new User();
		user.setPhone("你好");
		
		
		
		ResponseEntity<User> resqEntity = new ResponseEntity<User>(user, HttpStatus.OK);
		return resqEntity;
	}
	
	
	@RequestMapping(value = "/registered/action", method = RequestMethod.POST, produces="text/json;charset=UTF-8")
	public ResponseEntity<String> registered(HttpServletRequest req) {
		User user = new User();
		user.setMail(req.getParameter("user.mail"));
		user.setPhone(req.getParameter("user.phone"));
		String pwd = req.getParameter("user.pwd");
		
		userService.creatPwdMsg(user, pwd);
		
		String result = userService.registered(user); 

		if (result.equals("注册失败")) {
			return new ResponseEntity<String>(result, HttpStatus.OK);	
		} else {
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}		
	}
	
	
	@RequestMapping(value = "/registered/action.checkmail", method = RequestMethod.POST)
	public ResponseEntity<String> registeredChkMail(HttpServletRequest req) {
		String mail;
		mail = req.getParameter("user.mail");
		
		boolean result = userService.registerChkMail(mail);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		
		String msg;
		if (result) {
			msg = "邮箱可以注册";
		} else {
			msg = "邮箱已被使用";
		}
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> in(HttpServletRequest req) {
		User user = new User();
		
		user.setMail(req.getParameter("user.mail"));
		
		String pwd = req.getParameter("user.pwd");
		
		String msg;
		
		msg = userService.login(user, pwd);
		
		if (msg.equals("登陆成功")) {
			req.getSession().setAttribute("user", user);
		}
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
}
