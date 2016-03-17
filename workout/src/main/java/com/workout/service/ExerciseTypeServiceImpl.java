package com.workout.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.domain.ExerciseType;
import com.workout.dto.ExerciseTypeDto;
import com.workout.repository.ExerciseTypeRepository;

@Service
public class ExerciseTypeServiceImpl implements ExerciseTypeService {

	private final ExerciseTypeRepository exerciseTypeRepository;
	
	@Autowired
	public ExerciseTypeServiceImpl(ExerciseTypeRepository exerciseTypeRepository) {
		this.exerciseTypeRepository = exerciseTypeRepository;
	}

	@Override
	public ExerciseType createExerciseType(ExerciseTypeDto exerciseTypeDto, Long userId) {
		ExerciseType exerciseType = new ExerciseType(exerciseTypeDto.getName(), exerciseTypeDto.getDescription());
		exerciseType.setUserId(userId);
		
		return exerciseTypeRepository.save(exerciseType);
	}

	@Override
	@Transactional
	public void deleteExerciseType(ExerciseTypeDto exerciseTypeDto, Long userId) {
		exerciseTypeRepository.deleteByNameAndUserId(exerciseTypeDto.getName(), userId);
	}

	@Override
	public List<ExerciseType> getExerciseTypeForUser(Long userId) {
		return exerciseTypeRepository.findByUserId(userId);
	}
}
