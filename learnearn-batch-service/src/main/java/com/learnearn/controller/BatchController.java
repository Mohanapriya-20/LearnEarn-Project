package com.learnearn.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learnearn.model.Batch;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.IBatchService;

/**
 * @author MohanapriyaV
 *
 */
@RestController
@RequestMapping("/batch-service")
public class BatchController {
	IBatchService batchService;

	@Autowired
	public void setBatchService(IBatchService batchService) {
		this.batchService = batchService;
	}
  //this url is to add batch
	@PostMapping("/batches/addbatch/{companyId}")
	ResponseEntity<Batch> addBatch(@RequestBody Batch batch, @PathVariable int companyId) {
		Batch batchNew = batchService.addBatch(batch, companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Batch added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(batchNew);
	}
	//this url is to update batch
	@PutMapping("/batches")
	ResponseEntity<Batch> updateBatch(@RequestBody Batch batch) {
		batchService.updateBatch(batch);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	//this url is to delete batch
	@DeleteMapping("/batches/batchId/{batchId}")
	ResponseEntity<String> deleteBatch(@PathVariable("batchId") int batchId) {
		batchService.deleteBatch(batchId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
	//this url is to display the list of all batches
	@GetMapping("/batches")
	public ResponseEntity<List<Batch>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Batches");
		headers.add("info", "Returning All Batches");
		List<Batch> batchList = batchService.getAll();
		return ResponseEntity.ok().headers(headers).body(batchList);
	}
	//this url is to retrieve the batches by using batchId
	@GetMapping("/batches/{batchId}")
	ResponseEntity<Batch> getByBatchId(@PathVariable("batchId") int batchId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Id");
		headers.add("info", "Returning Batche By Id");
		Batch batch = batchService.getByBatchId(batchId);
		return ResponseEntity.ok().headers(headers).body(batch);

	}
	//this url is to retrieve the batches by using batchName
	@GetMapping("/batches/batchName/{batchName}")
	ResponseEntity<Batch> getByBatchName(@PathVariable("batchName") String batchName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By BatchName");
		headers.add("info", "Returning Batche By BatchName");
		Batch batch = batchService.getByBatchName(batchName);
		return ResponseEntity.ok().headers(headers).body(batch);

	}
	//this url is to retrieve the batches by using batch owner
	@GetMapping("/batches/owner/{owner}")
	ResponseEntity<List<Batch>> getByOwner(@PathVariable("owner") String owner) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Owner");
		headers.add("info", "Returning Batche By Owner");
		List<Batch> batchList = batchService.getByOwner(owner);
		return ResponseEntity.ok().headers(headers).body(batchList);

	}
	//this url is to retrieve the batches by using batch start anmd end date
	@GetMapping("/batches/startDate/{startDate}/endDate/{endDate}")
	ResponseEntity<List<Batch>> getByStartDateAndEndDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Start Date And End Date");
		headers.add("info", "Returning Batchs By Start Date And End Date");
		List<Batch> batchList = batchService.getByStartDateAndEndDate(LocalDateTime.parse(startDate),
				LocalDateTime.parse(endDate));
		return ResponseEntity.ok().headers(headers).body(batchList);
	}
	//this url is to retrieve the batches by using batch status
	@GetMapping("/batches/status/{status}")
	ResponseEntity<List<Batch>> getByStatus(@PathVariable("status") PostStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Status");
		headers.add("info", "Returning Batchs By Status");
		List<Batch> batchList = batchService.getByStatus(status);
		return ResponseEntity.ok().headers(headers).body(batchList);
	}
	//this url is to retrieve the batches by using batch priority
	@GetMapping("/batches/priority/{priority}")
	ResponseEntity<List<Batch>> getByPriority(@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Priority");
		headers.add("info", "Returning Batchs By Priority");
		List<Batch> batchList = batchService.getByPriority(priority);
		return ResponseEntity.ok().headers(headers).body(batchList);
	}
	//this url is to retrieve the batches by using batch name and course name
	@GetMapping("/batches/batchname/{batchName}/coursename/{courseName}")
	ResponseEntity<List<Batch>> getByBatchNameCourseName(@PathVariable("batchName") String batchName,
			@PathVariable("courseName") String courseName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Batch Name And Course Name");
		List<Batch> batchList = batchService.getByBatchNameCourseName(batchName, courseName);
		return ResponseEntity.ok().headers(headers).body(batchList);

	}
	//this url is to retrieve the batches by using batch name and course status
	@GetMapping("/batches/batchname/{batchName}/status/{status}")
	ResponseEntity<List<Batch>> getByBatchNameCourseStatus(@PathVariable("batchName") String batchName,
			@PathVariable("status") PostStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Batch Name And Status");
		List<Batch> batchList = batchService.getByBatchNameCourseStatus(batchName, status);
		return ResponseEntity.ok().headers(headers).body(batchList);

	}
	//this url is to retrieve the batches by using batch name and course priority
	@GetMapping("/batches/batchname/{batchName}/priority/{priority}")
	ResponseEntity<List<Batch>> getByBatchNameCoursePriority(@PathVariable("batchName") String batchName,
			@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Batch Name And  Course Priority");
		List<Batch> batchList = batchService.getByBatchNameCoursePriority(batchName, priority);
		return ResponseEntity.ok().headers(headers).body(batchList);

	}
	//this url is to retrieve the batches by using batch name and course start date
	@GetMapping("/batches/batchname/{batchName}/startDate/{startDate}")
	ResponseEntity<List<Batch>> getByBatchNameCourseStartDate(@PathVariable("batchName") String batchName,
			@PathVariable String startDate) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Batch Name And Course Start Date");
		List<Batch> batchList = batchService.getByBatchNameCourseStartDate(batchName, LocalDateTime.parse(startDate));
		return ResponseEntity.ok().headers(headers).body(batchList);

	}
	//this url is to retrieve the batches by using batch name and course owner
	@GetMapping("/batches/batchname/{batchName}/owner/{owner}")
	ResponseEntity<List<Batch>> getByBatchNameCourseOwner(@PathVariable("batchName") String batchName,
			@PathVariable("owner") String owner) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batches By Batch Name And Course Owner");
		List<Batch> batchList = batchService.getByBatchNameCourseOwner(batchName, owner);
		return ResponseEntity.ok().headers(headers).body(batchList);

	}

	// from course table
    // this url is to add course
	@PostMapping("/courses/addcourse/companyid/{companyId}/batchid/{batchId}")
	ResponseEntity<Course> addCourse(@RequestBody Course course, @PathVariable int companyId,
			@PathVariable int batchId) {
		ResponseEntity<Course> courseNew = batchService.addCourse(course, companyId, batchId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Task added");
		Course courseResponse = courseNew.getBody();
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(courseResponse);

	}
   // this url is to update course
	@PutMapping("/courses")
	ResponseEntity<Void> updateCourse(@RequestBody Course course) {
		batchService.updateCourse(course);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
   // this url is to delete course
	@DeleteMapping("/courses/{courseId}")
	ResponseEntity<String> deleteCourse(@PathVariable("courseId") int courseId) {
		batchService.deleteCourse(courseId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
    //this url is to retrieve courses by passing courseId
	@GetMapping("/courses/id/{courseId}")
	ResponseEntity<Course> getByCourseId(@PathVariable("courseId") int courseId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By Id");
		headers.add("info", "Returning one Course");
		Course courseResponse = batchService.getByCourseId(courseId);
		return ResponseEntity.ok().headers(headers).body(courseResponse);
	}
	//this url is to retrieve all courses
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Courses");
		headers.add("info", "Returning All Courses");
		List<Course> courseList = batchService.getAllCourses();
		return ResponseEntity.ok().headers(headers).body(courseList);

	}
	//this url is to retrieve courses by passing courseName
	@GetMapping("/courses/courseName/{courseName}")
	ResponseEntity<List<Course>> getByCourseName(@PathVariable("courseName") String courseName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By Course Name");
		headers.add("info", "Returning Course List");
		List<Course> courseList = batchService.getByCourseName(courseName);
		return ResponseEntity.ok().headers(headers).body(courseList);

	}
	//this url is to retrieve courses by passing course owner
	@GetMapping("/courses/owner/{owner}")
	ResponseEntity<List<Course>> getByCourseOwner(@PathVariable("owner") String owner) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By Course Owner");
		headers.add("info", "Returning Course List");
		List<Course> courseList = batchService.getByCourseOwner(owner);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}
	//this url is to retrieve courses by passing startdate and End Date
	@GetMapping("/courses/startdate/{startDate}/enddate/{endDate}")
	ResponseEntity<List<Course>> getByCourseStartDateEndDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By Start Date and End Date");
		headers.add("info", "Returning Course List");
		List<Course> courseList = batchService.getByStratDateAndEndDate(LocalDateTime.parse(startDate),
				LocalDateTime.parse(endDate));
		return ResponseEntity.ok().headers(headers).body(courseList);
	}
	//this url is to retrieve courses by passing status
	@GetMapping("/courses/status/{status}")
	ResponseEntity<List<Course>> getByCourseStatus(@PathVariable("status") PostStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By Status");
		headers.add("info", "Returning Course List");
		List<Course> courseList = batchService.getByCourseStatus(status);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}
	//this url is to retrieve courses by passing priority
	@GetMapping("/courses/priority/{priority}")
	ResponseEntity<List<Course>> getByCoursePriority(@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By Status");
		headers.add("info", "Returning Course List");
		List<Course> courseList = batchService.getByCoursePriority(priority);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}
	//this url is to retrieve courses by passing companyName and courseName
	@GetMapping("/courses/companyname/{companyName}/coursename/{courseName}")
	ResponseEntity<List<Course>> getByCompanyNameCourseName(@PathVariable("companyName") String companyName,
			@PathVariable("courseName") String courseName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By companyName and courseName");
		List<Course> courseList = batchService.getByCompanyNameCourseName(companyName, courseName);
		return ResponseEntity.ok().headers(headers).body(courseList);

	}
	//this url is to retrieve courses by passing companyName and status
	@GetMapping("/courses/companyname/{companyName}/status/{status}")
	ResponseEntity<List<Course>> getByCompanyNameCourseStatus(@PathVariable("companyName") String companyName,
			@PathVariable("status") PostStatus status) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By companyName and status");
		List<Course> courseList = batchService.getByCompanyNameCourseStatus(companyName, status);
		return ResponseEntity.ok().headers(headers).body(courseList);

	}

	@GetMapping("/courses/companyname/{companyName}/priority/{priority}")
	ResponseEntity<List<Course>> getByCompanyNameCoursePriority(@PathVariable("companyName") String companyName,
			@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get One Course By companyName and status");
		List<Course> courseList = batchService.getByCompanyNameCoursePriority(companyName, priority);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}

}
