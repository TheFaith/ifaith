package com.ifaith.fellowship.controller.people;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller(value = "/user")
@RestController("user")
public class UserController {
	@RequestMapping(name = "/test", method = RequestMethod.GET)
	public Object test() {
		return "Alan";
	}
}
