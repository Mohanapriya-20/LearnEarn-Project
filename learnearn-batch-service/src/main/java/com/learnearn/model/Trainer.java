package com.learnearn.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Trainer {
	@Id
	@GeneratedValue(generator = "trainer_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "trainer_gen", sequenceName = "trainer_seq", initialValue = 501, allocationSize = 1)
	private Integer trainerId;
	private String trainerName;
	private String courseType;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostAvailablity availablity;
	@OneToOne
	@JoinColumn(name = "course_id")
	Course course;

}
