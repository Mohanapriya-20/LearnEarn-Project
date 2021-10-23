package com.learnearn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learnearn.model.Batch;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
@Repository
public interface IBatchRepository extends JpaRepository<Batch, Integer> {
//derivedQuery

	Batch findByBatchName(String batchName);

	List<Batch> findByOwner(String owner);

	List<Batch> findByStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate);

	List<Batch> findByStatus(PostStatus status);

	List<Batch> findByPriority(PostPriority priority);
	
//customQuery
	@Query("from Batch b inner join b.courseList c where b.batchName=?1 and c.courseName=?2")
	List<Batch> findByBatchNameCourseName(String batchName,String courseName);
	
	@Query("from Batch b inner join b.courseList c where b.batchName=?1 and c.status=?2")
	List<Batch> findByBatchNameCourseStatus(String batchName,PostStatus status);
	
	@Query("from Batch b inner join b.courseList c where b.batchName=?1 and c.priority=?2")
	List<Batch> findByBatchNameCoursePriority(String batchName,PostPriority priority);
	
	@Query("from Batch b inner join b.courseList c where b.batchName=?1 and c.startDate=?2")
	List<Batch> findByBatchNameCourseStartDate(String batchName,LocalDateTime startDate);
	
	@Query("from Batch b inner join b.courseList c where b.batchName=?1 and c.owner=?2")
	List<Batch> findByBatchNameCourseOwner(String batchName,String owner);
	
	
	

}
