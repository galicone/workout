package com.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.dto.ExerciseReceiveDto;
import com.workout.service.ExerciseService;

@RestController
public class ExerciseController extends BaseController {

	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/training/{trainingId}/exercise", method = RequestMethod.POST)
	public void createExercise(@RequestBody ExerciseReceiveDto exerciseDto, @PathVariable Long trainingId) {
		// TODO  Mozda staviti proveru da je taj trening zakacen za tog usera ?!
		
		exerciseService.createExercise(exerciseDto, trainingId);
	}
	
	@RequestMapping(value = "/exercise/{exerciseId}", method = RequestMethod.DELETE)
	public void createExercise(@PathVariable Long exerciseId) {
		// TODO  Mozda staviti proveru da je taj trening zakacen za tog usera ?!
		
		exerciseService.removeExercise(exerciseId);
	}
	
}
