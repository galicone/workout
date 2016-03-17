package com.workout.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "exerciseType")
public class ExerciseTypeDto {

	@JsonProperty
	private Long id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String description;
	
	public ExerciseTypeDto() {
	}

	public ExerciseTypeDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
