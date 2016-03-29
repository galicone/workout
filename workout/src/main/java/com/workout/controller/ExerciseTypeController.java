package com.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.dto.ExerciseTypeDto;
import com.workout.service.ExerciseTypeService;

@RestController
public class ExerciseTypeController extends BaseController {

	@Autowired
	private ExerciseTypeService exerciseTypeService;
	
	@RequestMapping(value = "/exerciseType", method = RequestMethod.GET)
	public List<ExerciseTypeDto> getExerciseTypes() {
		return exerciseTypeService.getExerciseTypeForUser(getUserId());
	}
	
	@RequestMapping(value = "/exerciseType", method = RequestMethod.POST)
	public void createExerciseType(@RequestBody ExerciseTypeDto exerciseType) {
		exerciseTypeService.createExerciseType(exerciseType, getUserId());
	}
	
	@RequestMapping(value = "/exerciseType", method = RequestMethod.DELETE)
	public void removeExerciseType(@RequestBody ExerciseTypeDto exerciseTypeDto, @PathVariable Long userId) {
		exerciseTypeService.deleteExerciseType(exerciseTypeDto, userId);
	}
}
