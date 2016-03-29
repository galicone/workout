package com.workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.domain.Exercise;
import com.workout.domain.ExerciseType;
import com.workout.domain.Training;
import com.workout.dto.ExerciseReceiveDto;
import com.workout.repository.ExerciseRepository;
import com.workout.repository.ExerciseTypeRepository;
import com.workout.repository.TrainingRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private ExerciseTypeRepository exerciseTypeRepository;
	
	@Override
	public Exercise createExercise(ExerciseReceiveDto exerciseDto, Long trainingId) {
		Training training = trainingRepository.findOne(trainingId);
		ExerciseType exerciseType = exerciseTypeRepository.findOne(exerciseDto.getExerciseTypeId());
		
		Exercise exercise = new Exercise(exerciseDto.getRepeats(), exerciseDto.getDuration(), exerciseType, training);
		
		return exerciseRepository.save(exercise);
	}

	@Override
	public void removeExercise(Long exerciseId) {
		exerciseRepository.delete(exerciseId);		
	}
}
