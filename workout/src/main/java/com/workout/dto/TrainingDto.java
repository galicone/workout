package com.workout.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "training")
public class TrainingDto {

	@JsonProperty
	private LocalDate dateCreated;
	
	private Long id;
	
	private List<ExerciseSendDto> exercises;

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<ExerciseSendDto> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExerciseSendDto> exercises) {
		this.exercises = exercises;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
}
