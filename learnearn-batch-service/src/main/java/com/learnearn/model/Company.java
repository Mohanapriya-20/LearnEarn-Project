package com.learnearn.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Company {
	@Id
	@GeneratedValue(generator = "company_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "company_gen", sequenceName = "company_seq", initialValue = 101, allocationSize = 1)
	private Integer companyId;
	private String companyName;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostStatus status;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostPriority priority;
	@OneToMany // store the company and then Add the companyId while adding batchlist
	@JoinColumn(name = "company_id")
	Set<Batch> batchList;
	@OneToMany
	@JoinColumn(name = "company_id")
	Set<Course> courseList;

}
