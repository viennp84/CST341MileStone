package com.gcu.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.DataAccessInterface;
import com.gcu.business.SecurityInterface;
import com.gcu.business.UserDataAccessService;
import com.gcu.model.Admin;
import com.gcu.model.User;

/*
 * Vien Nguyen
 * CST341
 * 10/03/2020
 * User controller
 * User Controller will call the activities that responses for user business.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

	DataAccessInterface<User> dataAccessService = new UserDataAccessService();
	SecurityInterface<User> securityService = new UserDataAccessService();

	/*Dislay login form for user*/
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {

		ModelAndView modelAndView = new ModelAndView("adminLoginForm", "admin", new Admin());
		return modelAndView;
	}

	/* User login calling the login business */
	@RequestMapping(path = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("admin") Admin admin) {
		/* Check if the User is created */
		boolean isValid = securityService.login(admin);
		if (isValid) {
			return new ModelAndView("admin", "admin", admin);
		} else {
			return new ModelAndView("adminLoginForm", "admin", admin);
		}
	}
}
