package com.workout.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workout.domain.Training;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

	List<Training> findByUserIdAndDateCreated(Long userId, LocalDate dateCreated);
}
