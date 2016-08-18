package com.workout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.converter.TrainingConverter;
import com.workout.domain.Training;
import com.workout.dto.TrainingDto;
import com.workout.service.TrainingService;

@RestController
public class TrainingController extends BaseController {
	
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private TrainingConverter trainingConverter;

	@RequestMapping(value = "/training/{selectedDate}", method = RequestMethod.GET)
	public List<TrainingDto> getTrainings(@PathVariable String selectedDate) {
		List<TrainingDto> trainingDtos = new ArrayList<TrainingDto>();
		List<Training> trainings = trainingService.getTrainings(getUserId(), selectedDate);
		
		for (Training training : trainings) {
			trainingDtos.add(trainingConverter.convertToDto(training));
		}
		return trainingDtos;
	}
	
	@RequestMapping(value = "/training/{selectedDate}", method = RequestMethod.POST)
	public void createTraining(@PathVariable String selectedDate) {
		trainingService.createTraining(getUserId(), selectedDate);
	}
	
	@RequestMapping(value = "/training/{trainingId}", method = RequestMethod.DELETE)
	public void removeTraining(@PathVariable Long trainingId) {
		trainingService.removeTraining(trainingId);
	}
}
