package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.learnearn.exceptions.BatchNotFoundException;
import com.learnearn.exceptions.CourseNotFoundException;
import com.learnearn.exceptions.IdNotFoundException;
import com.learnearn.model.Batch;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

/**
 * @author MohanapriyaV
 *
 */
public interface IBatchService {
	
	//batch crud operations
	Batch addBatch(Batch batch, int companyId);

	void updateBatch(Batch batch);

	void deleteBatch(int batchId);

	List<Batch> getAll();
	
	//derived methods from batch

	Batch getByBatchId(int batchId) throws IdNotFoundException;

	Batch getByBatchName(String batchName) throws BatchNotFoundException;

	List<Batch> getByOwner(String owner) throws BatchNotFoundException;

	List<Batch> getByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) throws BatchNotFoundException;

	List<Batch> getByStatus(PostStatus status) throws BatchNotFoundException;

	List<Batch> getByPriority(PostPriority priority) throws BatchNotFoundException;
	
	// both batch and course
	//custom queries

	List<Batch> getByBatchNameCourseName(String batchName, String courseName) throws CourseNotFoundException;

	List<Batch> getByBatchNameCourseStatus(String batchName, PostStatus status) throws CourseNotFoundException;

	List<Batch> getByBatchNameCoursePriority(String batchName, PostPriority priority) throws CourseNotFoundException;

	List<Batch> getByBatchNameCourseStartDate(String batchName, LocalDateTime startDate) throws CourseNotFoundException;

	List<Batch> getByBatchNameCourseOwner(String batchName, String owner) throws CourseNotFoundException;

	// Methods from other microservices(Courses)
	//crud operations from courses
	
	List<Course> getAllCourses();

	ResponseEntity<Course> addCourse(Course course, int companyId, int batchId);

	void updateCourse(Course course);

	void deleteCourse(int courseId);

	// derived methods from courses
	
	Course getByCourseId(int courseId) throws IdNotFoundException;

	List<Course> getByCourseName(String courseName) throws CourseNotFoundException;

	List<Course> getByCourseOwner(String owner) throws CourseNotFoundException;

	List<Course> getByStratDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate)throws CourseNotFoundException;

	List<Course> getByCourseStatus(PostStatus status) throws CourseNotFoundException;

	List<Course> getByCoursePriority(PostPriority priority) throws CourseNotFoundException;

	//custom queries from courses
	List<Course> getByCompanyNameCourseName(String companyName, String courseName) throws CourseNotFoundException;

	List<Course> getByCompanyNameCourseStatus(String companyName, PostStatus status) throws CourseNotFoundException;

	List<Course> getByCompanyNameCoursePriority(String companyName, PostPriority priority)throws CourseNotFoundException;

}
