package com.workout.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.domain.Training;
import com.workout.repository.TrainingRepository;
import com.workout.util.DateUtils;

@Service
public class TrainingServiceImpl implements TrainingService {

	
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Override
	public Training createTraining(Long userId, String dateCreated) {
		LocalDate date = DateUtils.convertDateStringToDate(dateCreated);
		
		Training training = new Training(userId, date);
		return trainingRepository.save(training);
	}

	@Override
	public List<Training> getTrainings(Long userId, String selectedDate) {
		LocalDate date = DateUtils.convertDateStringToDate(selectedDate);
		
		return trainingRepository.findByUserIdAndDateCreated(userId, date);
	}

	@Override
	public void removeTraining(Long trainingId) {
		trainingRepository.delete(trainingId);
	}
}
