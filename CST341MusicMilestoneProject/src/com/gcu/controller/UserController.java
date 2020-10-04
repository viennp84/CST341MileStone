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
import com.gcu.model.User;

/*
 * Vien Nguyen
 * CST341
 * 10/03/2020
 * User controller
 * User Controller will call the activities that responses for user business.
 */

@Controller
@RequestMapping("/user")
public class UserController {

	DataAccessInterface<User> dataAccessService = new UserDataAccessService();
	SecurityInterface<User> securityService = new UserDataAccessService();

	/*Display the form for user register*/
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView displayForm() {

		ModelAndView modelAndView = new ModelAndView("addUser", "user", new User());
		return modelAndView;
	}

	/* Add user by calling the create user business */
	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {

		/* Check if the User is created */
		boolean isRegested = dataAccessService.create(user);
		if (isRegested) {
			return new ModelAndView("welcome", "user", user);
		} else {
			return new ModelAndView("addUser", "user", user);
		}
	}
	/*Dislay login form for user*/
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {

		ModelAndView modelAndView = new ModelAndView("login", "user", new User());
		return modelAndView;
	}

	/* User login calling the login business */
	@RequestMapping(path = "/userLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("user") User user) {
		/* Check if the User is created */
		boolean isValid = securityService.login(user);
		if (isValid) {
			return new ModelAndView("welcome", "user", user);
		} else {
			return new ModelAndView("login", "user", user);
		}
	}
}
