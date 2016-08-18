package com.workout.service;

import java.util.List;

import com.workout.domain.Training;

public interface TrainingService {

	Training createTraining(Long userId, String selectedDate);
	List<Training> getTrainings(Long userId, String selectedDate);
	void removeTraining(Long trainingId);
}
