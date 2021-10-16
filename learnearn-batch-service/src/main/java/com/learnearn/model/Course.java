package com.learnearn.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Course {
	@Id
	@GeneratedValue(generator="course_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="course_gen" ,sequenceName = "course_seq",initialValue = 1001,allocationSize = 1)
	private Integer courseId;
	private String courseName;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostStatus status;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostPriority priority;
	
	
	@ManyToOne
	@JoinColumn(name="company_id")
	Company company;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	Batch batch;
	

	
}
