package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learnearn.exception.CourseNotFoundException;
import com.learnearn.exception.IdNotFoundException;
import com.learnearn.model.Course;
import com.learnearn.model.PostAvailability;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.model.Trainer;
import com.learnearn.repository.ICourseRepository;
@Service
public class CourseServiceImpl implements ICourseService {

	ICourseRepository courseRepository;

	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Autowired
	RestTemplate restTemplate;

	public static final String BASEURL = "http://localhost:8084/trainer-service/trainers";


	@Override
	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {

		return courseRepository.save(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseRepository.save(course);

	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public Course getByCourseId(int courseId)  throws IdNotFoundException{
		Course course= courseRepository.findById(courseId).get();
		if(course!=null)
			return course;
		else
			throw new IdNotFoundException("no id found");	
	}

	@Override
	public List<Course> getByCourseName(String courseName) throws CourseNotFoundException{
		List<Course> courseList =courseRepository.findByCourseName(courseName);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}	

	@Override
	public List<Course> getByOwner(String owner) throws CourseNotFoundException{
		List<Course> courseList= courseRepository.findByOwner(owner);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByStratDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) throws CourseNotFoundException{
		List<Course> courseList=  courseRepository.findByStartDateAndEndDate(startDate, endDate);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByStatus(PostStatus status) throws CourseNotFoundException{
		List<Course> courseList=  courseRepository.findByStatus(status);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByPriority(PostPriority priority)throws CourseNotFoundException {
		List<Course> courseList=  courseRepository.findByPriority(priority);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByCompanyNameCourseName(String companyName, String courseName)throws CourseNotFoundException {
		List<Course> courseList=  courseRepository.findByCompanyNameCourseName(companyName, courseName);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByBatchNameCourseName(String batchName, String courseName) throws CourseNotFoundException{
		List<Course> courseList=  courseRepository.findByBatchNameCourseName(batchName, courseName);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByCompanyNameCourseStatus(String companyName, PostStatus status) throws CourseNotFoundException{
		List<Course> courseList=  courseRepository.findByCompanyNameCourseStatus(companyName, status);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByCompanyNameCoursePriority(String companyName, PostPriority priority)throws CourseNotFoundException {
		List<Course> courseList=  courseRepository.findByCompanyNameCoursePriority(companyName, priority);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByBatchNameCourseStatus(String bacthName, PostStatus status) throws CourseNotFoundException{
		List<Course> courseList=  courseRepository.findByBatchNameCourseStatus(bacthName, status);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByBatchNameCoursePriority(String bacthName, PostPriority priority) throws CourseNotFoundException{
		List<Course> courseList=  courseRepository.findByBatchNameCoursePriority(bacthName, priority);
		if(courseList.isEmpty())
			throw new CourseNotFoundException("no course found");
		else
			return courseList;
	}
	
	
	
	//resource methods

	@Override
	public Trainer getById(int trainerId) {
		String url=BASEURL+"/trainerId/"+trainerId;
		ResponseEntity<Trainer> trainer = restTemplate.getForEntity(url, Trainer.class);
		return trainer.getBody();
	}

	@Override
	public List<Trainer> getByTrainerAvailability(PostAvailability availability) {
		String url=BASEURL+"/availability/"+availability;
		ResponseEntity<List> trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	@Override
	public List<Trainer> getByTrainerName(String trainerName) {
		String url=BASEURL+"/trainerName/"+trainerName;
		ResponseEntity<List> trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	@Override
	public List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName) {
		String url=BASEURL+"/courseName/"+courseName+"/trainerName/"+trainerName;
		ResponseEntity<List> trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	@Override
	public List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability) {
		String url=BASEURL+"/courseName/"+courseName+"/availability/"+availability;
		ResponseEntity<List> trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	@Override
	public List<Trainer> getByOwnerAndTrainerName(String courseOwner, String trainerName) {
		String url=BASEURL+"/courseOwner/"+courseOwner+"/trainerName/"+trainerName;
		ResponseEntity<List> trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	@Override
	public List<Trainer> getByCourseStartDateAndAvailability(LocalDateTime courseStartDate,
			PostAvailability availability) {
		String url=BASEURL+"/courseStartDate/"+courseStartDate+"/availability/"+availability;
		ResponseEntity<List> trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	@Override
	public List<Trainer> getByCourseStatusAndTrainerName(PostStatus status, String trainerName) {
		String url=BASEURL+"/status/"+status+"/trainerName/"+trainerName;
		ResponseEntity<List>  trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}

	
	
	//resource important methods
	@Override
	public List<Trainer> viewTrainer() {
		String url=BASEURL+"/trainers/view-trainers";
		ResponseEntity<List>  trainerList=restTemplate.getForEntity(url, List.class);
		return trainerList.getBody();
	}



	@Override
	public Trainer assignTrainer(int courseId, int trainerId) {
		String url=BASEURL+"/trainers/assigntrainer/courseId/"+courseId+"/trainerId/"+trainerId;
		ResponseEntity<Trainer> trainer=restTemplate.getForEntity(url, Trainer.class);
		return trainer.getBody();
	}


	@Override
	public Trainer deAssignTrainer(int trainerId) {
		String url=BASEURL+"/trainers/deassigntrainer/trainerId/"+trainerId;
		ResponseEntity<Trainer> trainer=restTemplate.getForEntity(url, Trainer.class);
		return trainer.getBody();
	}

	
	
	
	

}
