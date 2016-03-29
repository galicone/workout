package com.workout.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workout.domain.User;
import com.workout.dto.CredentialsDto;
import com.workout.dto.CredentialsDto.UserDTO;
import com.workout.exception.ApplicationException;
import com.workout.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	public static String ROLE_USER = "ROLE_USER";

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public User registerUser(CredentialsDto credentials) throws ApplicationException {
		UserDTO userDTO = credentials.getUserDTO();

		validateUser(userDTO);

		User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(),
				passwordEncoder.encode(userDTO.getPassword()), true, ROLE_USER);

		return userRepository.save(user);
	}
	
	@Override
	public User findUser(Long userId) {
		return userRepository.findOne(userId);
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	private void validateUser(UserDTO userDTO) throws ApplicationException {
		// Check if User exists
		if (!userRepository.findByEmail(userDTO.getEmail()).isEmpty()) {
			throw new ApplicationContextException("User with this email already exists");
		}
	}
}
