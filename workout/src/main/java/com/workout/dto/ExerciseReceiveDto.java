package com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "exercise")
public class ExerciseReceiveDto {

	@JsonProperty
	private Long id;
	@JsonProperty
	private Integer repeats;
	@JsonProperty
	private Integer duration;
	@JsonProperty
	private Long exerciseTypeId;
	
	public ExerciseReceiveDto() {
	}
	
	public ExerciseReceiveDto(Integer repeats, Integer duration, Long exerciseTypeId) {
		super();
		this.repeats = repeats;
		this.duration = duration;
		this.exerciseTypeId = exerciseTypeId;
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

	public Long getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(Long exerciseTypeId) {
		this.exerciseTypeId = exerciseTypeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
