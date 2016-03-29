package com.workout.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workout.domain.Exercise;
import com.workout.domain.Training;
import com.workout.dto.ExerciseSendDto;
import com.workout.dto.TrainingDto;

@Component
public class TrainingConverter {

	@Autowired
	private ExerciseConverter exerciseConverter;
	
	public TrainingDto convertToDto(Training training) {
		TrainingDto trainingDto = new TrainingDto();
		List<ExerciseSendDto> exerciseDtos = new ArrayList<ExerciseSendDto>();

		if (training.getExercises() != null && !training.getExercises().isEmpty()) {
			for (Exercise exercise : training.getExercises()) {
				exerciseDtos.add(exerciseConverter.convertToDto(exercise));
			}
		}
		
		trainingDto.setExercises(exerciseDtos);
		trainingDto.setDateCreated(training.getDateCreated());
		trainingDto.setId(training.getId());
		
		return trainingDto;
	}
}
