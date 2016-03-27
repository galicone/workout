package com.workout.converter;

import org.springframework.stereotype.Component;

import com.workout.domain.ExerciseType;
import com.workout.dto.ExerciseTypeDto;

@Component
public class ExerciseTypeConverter {

	public ExerciseTypeDto convertToDto(ExerciseType exerciseType) {
		ExerciseTypeDto exerciseTypeDtO = new ExerciseTypeDto();
		
		exerciseTypeDtO.setId(exerciseType.getId());
		exerciseTypeDtO.setName(exerciseType.getName());
		exerciseTypeDtO.setDescription(exerciseType.getDescription());
		
		return exerciseTypeDtO;
	}
}
