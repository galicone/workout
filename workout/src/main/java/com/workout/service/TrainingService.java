package com.workout.service;

import java.util.List;

import com.workout.domain.Training;

public interface TrainingService {

	Training createTraining(Long userId);
	List<Training> getTrainings(Long userId);
	void removeTraining(Long trainingId);
}
