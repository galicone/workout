package com.workout.service;

import com.workout.domain.User;
import com.workout.dto.CredentialsDto;
import com.workout.exception.ApplicationException;

public interface UserService {

	public User registerUser(CredentialsDto credentials) throws ApplicationException;
	public User findUser(Long userId);
	public User saveUser(User user);
}
