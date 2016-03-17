package com.workout.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workout.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByEmail(String email);
}
