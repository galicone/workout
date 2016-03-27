package com.workout.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.converter.ExerciseTypeConverter;
import com.workout.domain.ExerciseType;
import com.workout.dto.ExerciseTypeDto;
import com.workout.repository.ExerciseTypeRepository;

@Service
public class ExerciseTypeServiceImpl implements ExerciseTypeService {

	@Autowired
	private ExerciseTypeConverter exerciseTypeConverter;
	@Autowired
	private ExerciseTypeRepository exerciseTypeRepository;

	@Override
	@Transactional
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
	public List<ExerciseTypeDto> getExerciseTypeForUser(Long userId) {
		List<ExerciseTypeDto> exerciseTypeDtos = new ArrayList<ExerciseTypeDto>();
		List<ExerciseType> exerciseTypes = exerciseTypeRepository.findByUserId(userId);
		
		for (ExerciseType exerciseType : exerciseTypes) {
			exerciseTypeDtos.add(exerciseTypeConverter.convertToDto(exerciseType));
		}
		
		return exerciseTypeDtos;
	}
}
