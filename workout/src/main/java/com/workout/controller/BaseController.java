package com.workout.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.workout.security.CustomUserDetails;

public class BaseController {

	public Long getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
		
		return userDetails.getId();
	}
}
