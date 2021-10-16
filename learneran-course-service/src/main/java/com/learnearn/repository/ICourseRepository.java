package com.learnearn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

	// derived
	Course findByCourseId(int courseId);

	List<Course> findByCourseName(String courseName);

	List<Course> findByOwner(String owner);

	List<Course> findByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);

	List<Course> findByStatus(PostStatus status);

	List<Course> findByPriority(PostPriority priority);

	// custom
	@Query("from Course c inner join c.company cp where cp.companyName=?1 and c.courseName=?2")
	List<Course> findByCompanyNameCourseName(String companyName, String courseName);

	@Query("from Course c inner join c.batch b where b.batchName=?1 and c.courseName=?2")
	List<Course> findByBatchNameCourseName(String batchName, String courseName);

	@Query("from Course c inner join c.company cp where cp.companyName=?1 and c.status=?2")
	List<Course> findByCompanyNameCourseStatus(String companyName, PostStatus status);

	@Query("from Course c inner join c.company cp where cp.companyName=?1 and c.priority=?2")
	List<Course> findByCompanyNameCoursePriority(String companyName, PostPriority priority);

	@Query("from Course c inner join c.batch b where b.batchName=?1 and c.status=?2")
	List<Course> findByBatchNameCourseStatus(String bacthName, PostStatus status);

	@Query("from Course c inner join c.batch b where b.batchName=?1 and c.priority=?2")
	List<Course> findByBatchNameCoursePriority(String bacthName, PostPriority priority);

}
