package com.workout.service;

import java.util.List;

import com.workout.domain.ExerciseType;
import com.workout.dto.ExerciseTypeDto;

public interface ExerciseTypeService {
	
	public ExerciseType createExerciseType(ExerciseTypeDto exerciseTypeDto, Long userId);
	
	public void deleteExerciseType(ExerciseTypeDto exerciseTypeDto, Long userId);
	
	public List<ExerciseType> getExerciseTypeForUser(Long userId);
}
