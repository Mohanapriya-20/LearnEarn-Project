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
@Entity
public class Company {
	@Id
	@GeneratedValue(generator = "company_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "company_gen",sequenceName = "company_seq",initialValue = 101,allocationSize = 1)
	private Integer companyId;
	@Column(length = 20)
	private String companyName;
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

	@OneToMany//store company and add company id while adding batchlist
	@JoinColumn(name = "company_id")
	private Set<Batch> batchList;

	@OneToMany
	@JoinColumn(name = "company_id")
	@JsonIgnore
	private Set<Course> courseList;

	
	

}
