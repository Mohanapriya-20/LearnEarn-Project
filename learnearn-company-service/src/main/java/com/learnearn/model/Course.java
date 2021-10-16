package com.learnearn.model;

import java.time.LocalDate;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course {
	
	private String courseName;
	@Id
	@GeneratedValue(generator="course_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="course_gen",sequenceName = "course_seq",initialValue = 1,allocationSize = 1)
	private Integer courseId;
	private String owner;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private PostStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(length=9)
	private PostPriority priority;
	
	


	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	
	
	

}
