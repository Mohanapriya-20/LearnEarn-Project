package com.learnearn.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Course {
	@Id
	@GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen",sequenceName = "course_seq",initialValue = 1001,allocationSize = 1)
	private Integer courseId;
	@Column(length = 20)
	private String courseName;
	@Column(length = 20)
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PostStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
    private PostPriority priority;
	
	@ManyToOne
	@JoinColumn(name = "batch_id")
	@JsonIgnore
	private Batch batch;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	@JsonIgnore
	private Company company;
	
	
}
