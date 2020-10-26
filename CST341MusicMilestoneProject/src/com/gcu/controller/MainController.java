package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.business.DataAccessInterface;
import com.gcu.business.SecurityInterface;
import com.gcu.business.UserDataAccessService;
import com.gcu.model.User;

@Controller
@RequestMapping("")
public class MainController {

	DataAccessInterface<User> dataAccessService = new UserDataAccessService();
	SecurityInterface<User> securityService = new UserDataAccessService();

	/*Display the form for user register*/
	@RequestMapping(path = "", method = RequestMethod.GET)
	public String displayHome() {
		
		return "welcome";
	}
}
