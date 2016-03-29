package com.workout.service;

import com.workout.domain.Exercise;
import com.workout.dto.ExerciseReceiveDto;

public interface ExerciseService {
	
	public Exercise createExercise(ExerciseReceiveDto exerciseDto, Long trainingId);
	public void removeExercise(Long exerciseId);
}
