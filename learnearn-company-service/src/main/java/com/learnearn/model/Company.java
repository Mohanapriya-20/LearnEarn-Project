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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
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
	@Column(length = 9)
	private PostStatus status;

	@Enumerated(EnumType.STRING)
	@Column(length = 9)
	private PostPriority priority;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Set<Batch> batchList;// one to many
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Set<Course> courseList;// one to many

	public Company(String companyName, String owner, LocalDateTime startDate, LocalDateTime endDate, PostStatus status,
			PostPriority priority) {
		super();
		this.companyName = companyName;
		this.owner = owner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", owner=" + owner + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + ", priority=" + priority + "]";
	}

}
