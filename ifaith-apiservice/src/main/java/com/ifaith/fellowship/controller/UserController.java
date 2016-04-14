package com.ifaith.fellowship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="/user")
public class UserController {
	@RequestMapping(method=RequestMethod.GET)
	public String showHomePage(Model model){
		model.addAttribute("message", "This is test message!");
		return "HomeView";
	}
}
