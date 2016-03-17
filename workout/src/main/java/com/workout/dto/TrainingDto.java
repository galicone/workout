package com.workout.dto;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "training")
public class TrainingDto {

	@JsonProperty
	private DateTime dateCreated;
	
	private Long id;
	
	private List<ExerciseDto> exercises;

	public DateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<ExerciseDto> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExerciseDto> exercises) {
		this.exercises = exercises;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
}
