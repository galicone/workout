package com.workout.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.converter.ExerciseTypeConverter;
import com.workout.domain.ExerciseType;
import com.workout.domain.User;
import com.workout.dto.CredentialsDTO;
import com.workout.dto.ExerciseTypeDto;
import com.workout.exception.ApplicationException;
import com.workout.service.ExerciseService;
import com.workout.service.ExerciseTypeService;
import com.workout.service.UserService;

@RestController
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private ExerciseTypeService exerciseTypeService;
	@Autowired
	private ExerciseService exerciseService;
	@Autowired
	private ExerciseTypeConverter exerciseTypeConverter;

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
	
	@RequestMapping(value = "/exerciseType", method = RequestMethod.GET)
	public List<ExerciseTypeDto> getExerciseTypes() {
		List<ExerciseType> exerciseTypes = exerciseTypeService.getExerciseTypeForUser(getUserId());
		List<ExerciseTypeDto> exerciseTypeDtos = new ArrayList<ExerciseTypeDto>();
		
		for (ExerciseType exerciseType : exerciseTypes) {
			exerciseTypeDtos.add(exerciseTypeConverter.convertToDto(exerciseType));
		}
		return exerciseTypeDtos;
	}
	
	@RequestMapping(value = "/exerciseType", method = RequestMethod.POST)
	public void createExerciseType(@RequestBody ExerciseTypeDto exerciseTypeDto, @PathVariable Long userId) {
		exerciseTypeService.createExerciseType(exerciseTypeDto, userId);
	}
	
	@RequestMapping(value = "/exerciseType", method = RequestMethod.DELETE)
	public void removeExerciseType(@RequestBody ExerciseTypeDto exerciseTypeDto, @PathVariable Long userId) {
		exerciseTypeService.deleteExerciseType(exerciseTypeDto, userId);
	}
}
