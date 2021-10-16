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
public class Batch {
	@Id
	@GeneratedValue(generator="batch_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="batch_gen" ,sequenceName = "batch_seq",initialValue = 1,allocationSize = 1)
	private Integer batchId;
	private String batchName;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostStatus status;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private PostPriority priority;
	
	public Batch(String batchName, String owner, LocalDateTime startDate, LocalDateTime endDate, PostStatus status,
			PostPriority priority) {
		super();
		this.batchName = batchName;
		this.owner = owner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.priority = priority;
		
	}
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@OneToMany
	@JoinColumn(name="batch_id")
	private Set<Course> courseList;

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", owner=" + owner + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + ", priority=" + priority + ", courseList="
				+ courseList + "]";
	}
}
