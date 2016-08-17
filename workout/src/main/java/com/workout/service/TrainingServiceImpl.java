package com.workout.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.domain.Training;
import com.workout.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {

	private static final String DATE_FORMATE = "dd-MM-yyyy";
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Override
	public Training createTraining(Long userId) {
		Training training = new Training(userId);
		return trainingRepository.save(training);
	}

	@Override
	public List<Training> getTrainings(Long userId, String selectedDate) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATE);
		LocalDate date = LocalDate.parse(selectedDate, dateTimeFormatter);
		
		return trainingRepository.findByUserIdAndDateCreated(userId, date);
	}

	@Override
	public void removeTraining(Long trainingId) {
		trainingRepository.delete(trainingId);
	}
}
