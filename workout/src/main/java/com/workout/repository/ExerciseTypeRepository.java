package com.workout.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workout.domain.ExerciseType;

@Repository
public interface ExerciseTypeRepository extends CrudRepository<ExerciseType, Long> {

	public void deleteByNameAndUserId(String name, Long userId);
	
	public List<ExerciseType> findByUserId(Long userId);
}
