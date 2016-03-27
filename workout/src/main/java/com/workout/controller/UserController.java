package com.workout.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.domain.User;
import com.workout.dto.CredentialsDTO;
import com.workout.exception.ApplicationException;
import com.workout.service.ExerciseService;
import com.workout.service.UserService;

@RestController
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public User registerUser(@RequestBody CredentialsDTO credentials) {
		try {
			return userService.registerUser(credentials);
		} catch (ApplicationException e) {
			return null;
		}
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public Principal loginUser(Principal user) {
		return user;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	}
}
