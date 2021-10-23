package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import com.learnearn.exception.CourseNotFoundException;
import com.learnearn.exception.IdNotFoundException;
import com.learnearn.model.Course;
import com.learnearn.model.PostAvailability;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.model.Trainer;

public interface ICourseService {

	List<Course> getAll();

	Course addCourse(Course course, int companyId, int batchId);

	void updateCourse(Course course);

	void deleteCourse(int courseId);

	Course getByCourseId(int courseId) throws IdNotFoundException;

	List<Course> getByCourseName(String courseName) throws CourseNotFoundException;

	List<Course> getByOwner(String owner) throws CourseNotFoundException;

	List<Course> getByStratDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate)
			throws CourseNotFoundException;

	List<Course> getByStatus(PostStatus status) throws CourseNotFoundException;

	List<Course> getByPriority(PostPriority priority) throws CourseNotFoundException;

	// custom
	List<Course> getByCompanyNameCourseName(String companyName, String courseName) throws CourseNotFoundException;

	List<Course> getByBatchNameCourseName(String batchName, String courseName) throws CourseNotFoundException;

	List<Course> getByCompanyNameCourseStatus(String companyName, PostStatus status) throws CourseNotFoundException;

	List<Course> getByCompanyNameCoursePriority(String companyName, PostPriority priority)
			throws CourseNotFoundException;

	List<Course> getByBatchNameCourseStatus(String batchName, PostStatus status) throws CourseNotFoundException;

	List<Course> getByBatchNameCoursePriority(String batchName, PostPriority priority) throws CourseNotFoundException;

	Trainer getCourseTrainerDetails(int courseId);

	// for resource

	Trainer getById(int trainerId);

	List<Trainer> getByTrainerAvailability(PostAvailability availability);

	List<Trainer> getByTrainerName(String trainerName);

	List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName);

	List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability);

	List<Trainer> getByOwnerAndTrainerName(String courseOwner, String trainerName);

	List<Trainer> getByCourseStartDateAndAvailability(LocalDateTime courseStartDate, PostAvailability availability);

	List<Trainer> getByCourseStatusAndTrainerName(PostStatus status, String trainerName);

	// view and assign
	List<Trainer> viewTrainer();

	void assignTrainer(int courseId, int trainerId);

	void deAssignTrainer(int courseId, int trainerId);

}
