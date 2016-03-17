package com.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.domain.Training;
import com.workout.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;
	
	@Override
	public Training createTraining(Long userId) {
		Training training = new Training(userId);
		return trainingRepository.save(training);
	}

	@Override
	public List<Training> getTrainings(Long userId) {
		return trainingRepository.findByUserId(userId);
	}

	@Override
	public void removeTraining(Long trainingId) {
		trainingRepository.delete(trainingId);
	}
}
