package com.workout.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workout.domain.Exercise;
import com.workout.dto.ExerciseDto;

@Component
public class ExerciseConverter {
	
	@Autowired
	private ExerciseTypeConverter exerciseTypeConverter;
	
	public ExerciseDto convertToDto(Exercise exercise) {
		ExerciseDto exerciseDto = new ExerciseDto();
		
		exerciseDto.setId(exercise.getId());
		exerciseDto.setRepeats(exercise.getRepeats());
		exerciseDto.setDuration(exercise.getDuration());
		exerciseDto.setExerciseType(exerciseTypeConverter.convertToDto(exercise.getExerciseType()));
		
		return exerciseDto;
	}
}
