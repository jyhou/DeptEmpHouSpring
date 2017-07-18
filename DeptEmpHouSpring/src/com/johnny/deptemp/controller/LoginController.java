package com.johnny.deptemp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnny.deptemp.service.ValidateUser;
import com.johnny.deptemp.service.Validator;

@Controller
@RequestMapping({"","/"})
public class LoginController {
	@Autowired
	Validator validator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showIndex(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(ModelMap model, HttpSession session, @RequestParam("userName") String userName, @RequestParam("password") String password) {
//		if (userName == null && password == null) {
//			model.addAttribute("isValidUser", false);
//			return "index";
//		}
		if (ValidateUser.validateUser(userName, password)) {
			session.setAttribute("isValidUser", true);
			session.setAttribute("currentUser", "Johnny");
			return "manage";
		} else {
			model.addAttribute("isValidUser", false);
			return "index";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public String showManage(ModelMap model) {
		return "manage";
	}

}
