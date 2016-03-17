package com.workout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workout.domain.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long>{

}
