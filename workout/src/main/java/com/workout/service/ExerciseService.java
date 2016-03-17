package com.workout.service;

import com.workout.domain.Exercise;
import com.workout.dto.ExerciseDto;

public interface ExerciseService {
	
	public Exercise createExercise(ExerciseDto exerciseDto, Long trainingId);
	public void removeExercise(Long exerciseId);
}
