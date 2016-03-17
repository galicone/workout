package com.workout.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity(name = "TRAINING")
public class Training {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DATE_CREATED")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateCreated;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "training")
	List<Exercise> exercises;
	
	public Training() {
	}
	
	public Training(Long userId) {
		this.userId = userId;
		this.dateCreated = DateTime.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(DateTime dateCreated) {
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
