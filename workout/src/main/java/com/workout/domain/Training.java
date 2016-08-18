package com.workout.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TRAINING")
public class Training {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DATE_CREATED")
	private LocalDate dateCreated;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "training")
	List<Exercise> exercises;
	
	public Training() {
	}
	
	public Training(Long userId, LocalDate dateCreated) {
		this.userId = userId;
		this.dateCreated = dateCreated;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
