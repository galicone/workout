package com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExerciseSendDto {
	
	@JsonProperty
	private Long id;
	@JsonProperty
	private Integer repeats;
	@JsonProperty
	private Integer duration;
	@JsonProperty
	private ExerciseTypeDto exerciseType;
	
	public ExerciseSendDto() {
	}
	
	public ExerciseSendDto(Integer repeats, Integer duration, ExerciseTypeDto exerciseType) {
		super();
		this.repeats = repeats;
		this.duration = duration;
		this.exerciseType = exerciseType;
	}
	
	public Integer getRepeats() {
		return repeats;
	}
	public void setRepeats(Integer repeats) {
		this.repeats = repeats;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public ExerciseTypeDto getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseTypeDto exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}