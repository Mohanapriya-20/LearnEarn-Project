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
import org.springframework.web.client.RestTemplate;

import com.learnearn.model.Batch;
import com.learnearn.model.Course;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.IBatchService;

@RestController
@RequestMapping("/batch-service")
public class BatchController {
	IBatchService batchService;

	@Autowired
	public void setBatchService(IBatchService batchService) {
		this.batchService = batchService;
	}

	@PostMapping("/batches/addbatch/{companyId}")
	ResponseEntity<Batch> addBatch(@RequestBody Batch batch,@PathVariable int companyId) {
		Batch batchNew=batchService.addBatch(batch,companyId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Batch added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(batchNew);
	}

	@PutMapping("/batches")
	ResponseEntity<Batch> updateBatch(@RequestBody Batch batch) {
		batchService.updateBatch(batch);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping("/batches/batchId/{batchId}")
        ResponseEntity<String> deleteBatch(@PathVariable("batchId") int batchId) {
		batchService.deleteBatch(batchId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}

	@GetMapping("/batches")
	public ResponseEntity<List<Batch>> getAll() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get All Batches");
		headers.add("info","Returning All Batches");
		List<Batch> batchList=batchService.getAll();
		return ResponseEntity.ok().headers(headers).body(batchList);
	}

	@GetMapping("/batches/{batchId}")
	ResponseEntity<Batch> getByBatchId(@PathVariable("batchId") int batchId) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Id");
		headers.add("info","Returning Batche By Id");
	    Batch batch= batchService.getByBatchId(batchId);
	    return ResponseEntity.ok().headers(headers).body(batch);

	}

	@GetMapping("/batches/batchName/{batchName}")
	ResponseEntity<Batch> getByBatchName(@PathVariable("batchName") String batchName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By BatchName");
		headers.add("info","Returning Batche By BatchName");
		 Batch batch=  batchService.getByBatchName(batchName);
		 return ResponseEntity.ok().headers(headers).body(batch);

	}

	@GetMapping("/batches/owner/{owner}")
	ResponseEntity<List<Batch>> getByOwner(@PathVariable("owner") String owner) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Owner");
		headers.add("info","Returning Batche By Owner");
		List<Batch> batchList= batchService.getByOwner(owner);
		 return ResponseEntity.ok().headers(headers).body(batchList);
		
	}

	@GetMapping("/batches/startDate/{startDate}/endDate/{endDate}")
	ResponseEntity<List<Batch>> getByStartDateAndEndDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Start Date And End Date");
		headers.add("info","Returning Batchs By Start Date And End Date");
		List<Batch> batchList= batchService.getByStartDateAndEndDate(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
		 return ResponseEntity.ok().headers(headers).body(batchList);
	}

	@GetMapping("/batches/status/{status}")
	ResponseEntity<List<Batch>>getByStatus(@PathVariable("status") PostStatus status) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Status");
		headers.add("info","Returning Batchs By Status");
		List<Batch> batchList=  batchService.getByStatus(status);
		 return ResponseEntity.ok().headers(headers).body(batchList);
	}

	@GetMapping("/batches/priority/{priority}")
	ResponseEntity<List<Batch>> getByPriority(@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Priority");
		headers.add("info","Returning Batchs By Priority");
		List<Batch> batchList=  batchService.getByPriority(priority);
		return ResponseEntity.ok().headers(headers).body(batchList);
	}
    // from course table 
	// derived
	
	@PostMapping("/courses")
	ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course courseNew=batchService.addCourse(course);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Task added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(courseNew);
		
	}
	@PutMapping("/courses")
	ResponseEntity<Void> updateCourse(@RequestBody Course course) {
		batchService.updateCourse(course);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	@DeleteMapping("/courses/{courseId}")
	ResponseEntity<String> deleteCourse(@PathVariable("courseId") int courseId) {
		batchService.deleteCourse(courseId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
	@GetMapping("/courses/id/{courseId}")
	ResponseEntity<Course> getByCourseId(@PathVariable("courseId")int courseId) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get One Course By Id");
		headers.add("info","Returning one Course");
		Course courseResponse=batchService.getByCourseId(courseId);
		return ResponseEntity.ok().headers(headers).body(courseResponse);
	}
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get All Courses");
		headers.add("info","Returning All Courses");
		List<Course> courseList=batchService.getAllCourses();
		return ResponseEntity.ok().headers(headers).body(courseList);

	}
	@GetMapping("/courses/courseName/{courseName}")
	ResponseEntity<List<Course>> getByCourseName(@PathVariable("courseName") String courseName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get One Course By Course Name");
		headers.add("info","Returning Course List");
		List<Course> courseList=batchService.getByCourseName(courseName);
		return ResponseEntity.ok().headers(headers).body(courseList);
		

	}
	@GetMapping("/courses/owner/{owner}")
	ResponseEntity<List<Course>> getByCourseOwner(@PathVariable("owner") String owner) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get One Course By Course Owner");
		headers.add("info","Returning Course List");
		List<Course> courseList= batchService.getByCourseOwner(owner);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}

	@GetMapping("/courses/startdate/{startDate}/enddate/{endDate}")
	ResponseEntity<List<Course>> getByCourseStartDateEndDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get One Course By Start Date and End Date");
		headers.add("info","Returning Course List");
		List<Course> courseList= batchService.getByStratDateAndEndDate(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
		return ResponseEntity.ok().headers(headers).body(courseList);
	}

	@GetMapping("/courses/status/{status}")
	ResponseEntity<List<Course>> getByCourseStatus(@PathVariable("status") PostStatus status) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get One Course By Status");
		headers.add("info","Returning Course List");
		List<Course> courseList= batchService.getByCourseStatus(status);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}

	@GetMapping("/courses/priority/{priority}")
	ResponseEntity<List<Course>> getByCoursePriority(@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get One Course By Status");
		headers.add("info","Returning Course List");
		List<Course> courseList= batchService.getByCoursePriority(priority);
		return ResponseEntity.ok().headers(headers).body(courseList);
	}


	
	
	
//	@GetMapping("/courses")
//	public List<Course> getAllCourses() {
//		return batchService.getAllCourses();
//
//	}

//	@GetMapping("/courses/{courseId}")
//	Course getByCourseId(@PathVariable("courseId") int courseId) {
//		return batchService.getByCourseId(courseId);
//
//	}
//
//	@GetMapping("/courses/courseName/{courseName}")
//	List<Course> getByCourseName(@PathVariable("courseName") String courseName) {
//		return batchService.getByCourseName(courseName);
//
//	}

//	@GetMapping("/courses/owner/{owner}")
//	List<Course> getByCourseOwner(@PathVariable("owner") String owner) {
//		return batchService.getByCourseOwner(owner);
//	}
//
//	@GetMapping("/courses/startdate/{startDate}/enddate/{endDate}")
//	List<Course> getByCourseStartDateEndDate(@PathVariable("startDate") String startDate,
//			@PathVariable("endDate") String endDate) {
//		return batchService.getByStratDateAndEndDate(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
//	}
//
//	@GetMapping("/courses/status/{status}")
//	List<Course> getByCourseStatus(@PathVariable("status") PostStatus status) {
//		return batchService.getByCourseStatus(status);
//	}
//
//	@GetMapping("/courses/priority/{priority}")
//	List<Course> getByCoursePriority(@PathVariable("priority") PostPriority priority) {
//		return batchService.getByCoursePriority(priority);
//	}
//	// custom queries in batch
//	@GetMapping("/batches/batchName/{batchName}/courseName/{courseName}")
//	public List<Batch> getByBatchNameCourseName(String batchName,String courseName)
//	{
//		return batchService.getByBatchNameCourseName(batchName, courseName);
//	}

}
