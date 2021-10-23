package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learnearn.exceptions.BatchNotFoundException;
import com.learnearn.exceptions.CourseNotFoundException;
import com.learnearn.exceptions.IdNotFoundException;
import com.learnearn.model.Batch;
import com.learnearn.model.Company;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.repository.IBatchRepository;

/**
 * @author MohanapriyaV
 *
 */
@Service
public class BatchServiceImpl implements IBatchService {

	RestTemplate restTemplate;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Autowired
	IBatchRepository batchRepository;
	private static final String BASEURL = "http://localhost:8083/course-service/courses";

     //to add batch
	@Override
	public Batch addBatch(Batch batch, int companyId) {
		String companyUrl = "http://localhost:8081/company-service/company/companyId/" + companyId;
		ResponseEntity<Company> company = restTemplate.getForEntity(companyUrl, Company.class);
		Company companyNew = company.getBody();
		batch.setCompany(companyNew);
		return batchRepository.save(batch);
	}
     //to update batch
	@Override
	public void updateBatch(Batch batch) {
		batchRepository.save(batch);
	}
     //to delete batch
	@Override
	public void deleteBatch(int batchId) {
		batchRepository.deleteById(batchId);
	}
     // to get the list of all batch
	@Override
	public List<Batch> getAll() {
		return batchRepository.findAll();
	}
     // to retrieve the batch by passing id
	@Override
	public Batch getByBatchId(int batchId) throws IdNotFoundException {
		return batchRepository.findById(batchId).orElseThrow(() -> new IdNotFoundException("Invalid Batch Id "));

	}
	 // to retrieve the batch by passing Batch Name
	@Override
	public Batch getByBatchName(String batchName) throws BatchNotFoundException {
		Batch batch = batchRepository.findByBatchName(batchName);
		if (batch == null)
			throw new IdNotFoundException("Invalid Batch Name!!");
		return batch;
	}
	 // to retrieve the batch by passing Batch owner
	@Override
	public List<Batch> getByOwner(String owner) throws BatchNotFoundException {
		List<Batch> batchList = batchRepository.findByOwner(owner);
		if (batchList.isEmpty())
			throw new BatchNotFoundException("Invalid Owner Name!!");
		return batchList;
	}
	 // to retrieve the batch by passing Start and End date
	@Override
	public List<Batch> getByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate)
			throws BatchNotFoundException {
		List<Batch> batchList = batchRepository.findByStartDateAndEndDate(startDate, endDate);
		if (batchList.isEmpty())
			throw new BatchNotFoundException("Invalid Start and End date!!");
		return batchList;
	}
	 // to retrieve the batch by passing status
	@Override
	public List<Batch> getByStatus(PostStatus status) throws BatchNotFoundException {
		List<Batch> batchList = batchRepository.findByStatus(status);
		if (batchList.isEmpty())
			throw new BatchNotFoundException("Currently No Batch hold this Status!!");
		return batchList;
	}
	 // to retrieve the batch by passing priority
	@Override
	public List<Batch> getByPriority(PostPriority priority) throws BatchNotFoundException {
		List<Batch> batchList = batchRepository.findByPriority(priority);
		if (batchList.isEmpty())
			throw new BatchNotFoundException("Currently No Batch hold this Priority!!");
		return batchList;
	}
	 // to retrieve the batch by passing Batch name and course name
	@Override
	public List<Batch> getByBatchNameCourseName(String batchName, String courseName) {
		return batchRepository.findByBatchNameCourseName(batchName, courseName);
	}
	 // to retrieve the batch by passing Batch name and course status
	@Override
	public List<Batch> getByBatchNameCourseStatus(String batchName, PostStatus status) {
		return batchRepository.findByBatchNameCourseStatus(batchName, status);
	}
	 // to retrieve the batch by passing batch name and course priority
	@Override
	public List<Batch> getByBatchNameCoursePriority(String batchName, PostPriority priority) {
		return batchRepository.findByBatchNameCoursePriority(batchName, priority);
	}
	 // to retrieve the batch by passing batch name and course start date
	@Override
	public List<Batch> getByBatchNameCourseStartDate(String batchName, LocalDateTime startDate) {
		return batchRepository.findByBatchNameCourseStartDate(batchName, startDate);
	}
	// to retrieve the batch by passing batch name and course owner
	@Override
	public List<Batch> getByBatchNameCourseOwner(String batchName, String owner) {
		return batchRepository.findByBatchNameCourseOwner(batchName, owner);
	}
	// to add course of  other microservices from batch
	@Override 
	public ResponseEntity<Course> addCourse(Course course, int companyId, int batchId) {
		String url = BASEURL + "/addcourse/companyid/" + companyId + "/batchid/" + batchId;
		ResponseEntity<Course> courseObj = restTemplate.postForEntity(url, course, Course.class);
		return courseObj;

	}
	// to update course of  other microservices from batch
	@Override
	public void updateCourse(Course course) {
		String url = BASEURL;
		ResponseEntity<Course> courseObj = restTemplate.getForEntity(url, Course.class);

	}
	// to update course of  other microservices from batch
	@Override
	public void deleteCourse(int courseId) {
		String url = BASEURL + "/id/" + courseId;
		ResponseEntity<Course> courseObj = restTemplate.getForEntity(url, Course.class);

	}
	// to retrieve list of all courses of  other microservices from batch
	@Override
	public List<Course> getAllCourses() {
		String url = BASEURL;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing courseId of other microservices from batch
	@Override
	public Course getByCourseId(int courseId) throws IdNotFoundException {
		String url = BASEURL + "/id/" + courseId;
		ResponseEntity<Course> course = restTemplate.getForEntity(url, Course.class);
		return course.getBody();
	}
	// to retrieve courses by passing courseName of other microservices from batch
	@Override
	public List<Course> getByCourseName(String courseName) throws CourseNotFoundException {
		String url = BASEURL + "/name/" + courseName;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();

	}
	// to retrieve courses by passing owner of other microservices from batch
	@Override
	public List<Course> getByCourseOwner(String owner) throws CourseNotFoundException {
		String url = BASEURL + "/owner/" + owner;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing StartDateAndEndDate of other microservices from batch
	@Override
	public List<Course> getByStratDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate)
			throws CourseNotFoundException {
		String url = BASEURL + "/startdate/" + startDate + "/enddate/" + endDate;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing CourseStatus of other microservices from batch
	@Override
	public List<Course> getByCourseStatus(PostStatus status) throws CourseNotFoundException {
		String url = BASEURL + "/status/" + status;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing CoursePriority of other microservices from batch
	@Override
	public List<Course> getByCoursePriority(PostPriority priority) throws CourseNotFoundException {
		String url = BASEURL + "/priority/" + priority;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing CompanyNameCourseName of other microservices from batch
	@Override
	public List<Course> getByCompanyNameCourseName(String companyName, String courseName)
			throws CourseNotFoundException {
		String url = BASEURL + "/companyname/" + companyName + "/coursename/" + courseName;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing CompanyNameCourseStatus of other microservices from batch
	@Override
	public List<Course> getByCompanyNameCourseStatus(String companyName, PostStatus status)
			throws CourseNotFoundException {
		String url = BASEURL + "/companyname/" + companyName + "/status/" + status;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}
	// to retrieve courses by passing CompanyNameCoursePriority of other microservices from batch
	@Override
	public List<Course> getByCompanyNameCoursePriority(String companyName, PostPriority priority)
			throws CourseNotFoundException {
		String url = BASEURL + "/companyname/" + companyName + "/priority/" + priority;
		ResponseEntity<List> courseList = restTemplate.getForEntity(url, List.class);
		return courseList.getBody();
	}

}
