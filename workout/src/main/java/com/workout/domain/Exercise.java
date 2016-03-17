package com.workout.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "EXERCISE")
public class Exercise {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "REPEATS")
	private Integer repeats;

	@Column(name = "DURATION")
	private Integer duration;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="EXERCISE_TYPE_ID")
	private ExerciseType exerciseType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRAINING_ID", nullable = false)
	private Training training;

	public Exercise() {
	}
	
	public Exercise(Integer repeats, Integer duration, ExerciseType exerciseType, Training training) {
		super();
		this.repeats = repeats;
		this.duration = duration;
		this.exerciseType = exerciseType;
		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ExerciseType getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(ExerciseType exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Training getTraining() {
		return training;
	}

	public void setTrainingId(Training training) {
		this.training = training;
	}
}