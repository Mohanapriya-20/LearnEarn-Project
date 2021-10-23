package com.learnearn.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnearn.model.Batch;
import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.service.ICompanyService;

@RestController
@RequestMapping("/company-service")
public class CompanyController {
	@Autowired
	ICompanyService companyService;

	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAll() {

		List<Company> company = companyService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Company Details");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(company);

	}

	@GetMapping("/company/companyId/{companyId}")
	public ResponseEntity<Company> getById(@PathVariable("companyId") int companyId) {

		Company ncompany = companyService.getById(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Company Details By Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(ncompany);
	}

	@PostMapping("/company")
	ResponseEntity<Company> addCompany(@RequestBody Company company) {
		Company ncompany = companyService.addCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Company added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(ncompany);

	}

	@PatchMapping("/company")
	ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		Company updateCompany = companyService.updateCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Company Updated");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(updateCompany);

	}

	@DeleteMapping("/company/{companyId}")
	ResponseEntity<String> deleteCompany(@PathVariable("companyId") int companyId) {
		String deleteCompany = companyService.deleteCompany(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Company Deleted");
		headers.add("info", "Company ");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(deleteCompany);
	}

	@GetMapping("/company/companyName/{companyName}")
	ResponseEntity<List<Company>> getByCompanyName(@PathVariable("companyName") String companyName) {
		List<Company> company = companyService.getByCompanyName(companyName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Company By Name");
		headers.add("info", "Return Company Name");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(company);
	}

	@GetMapping("/company/owner/{owner}")
	public ResponseEntity<Company> getByOwner(@PathVariable("owner") String owner) {
		Company companyOwner = companyService.getByOwner(owner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get the Company Owner");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyOwner);

	}

	@GetMapping("/company/startDate/{startDate}/endDate/{endDate}")
	List<Company> getByStartDateAndEndDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		return companyService.getByStartDateAndEndDate(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
	}

	@GetMapping("/company/priority/{priority}")
	ResponseEntity<List<Company>> getByPriority(@PathVariable("priority") PostPriority priority) {
		List<Company> companyPriority = companyService.getByPriority(priority);

		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get the Company Owner");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyPriority);

	}

	@GetMapping("/company/status/{status}")
	ResponseEntity<List<Company>> getByStatus(@PathVariable("status") PostStatus status) {
		List<Company> companyStatus = companyService.getByStatus(status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get By Status");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyStatus);

	}

	@GetMapping("/company/batchName/{batchName}/companyName/{companyName}")
	ResponseEntity<List<Company>> getByBatchNameAndCompanyName(@PathVariable String batchName,
			@PathVariable String companyName) {
		List<Company> companyList = companyService.getByBatchNameAndCompanyName(batchName, companyName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get  by  Batch Name and Company Name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);
	}

	@GetMapping("/company/batchName/{batchName}/owner/{owner}")
	ResponseEntity<List<Company>> getByBatchNameAndCompanyOwner(@PathVariable String batchName,
			@PathVariable String owner) {
		List<Company> companyList = companyService.getByBatchNameAndCompanyOwner(batchName, owner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get  by  Batch Name and Company  Owner");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}

	@GetMapping("/company/batchOwner/{batchOwner}/priority/{priority}")
	ResponseEntity<List<Company>> getByBatchOwnerAndCompanyPriority(@PathVariable String batchName,
			@PathVariable PostPriority priority) {
		List<Company> companyList = companyService.getByBatchOwnerAndCompanyPriority(batchName, priority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get  by  Batch Owner and Priority");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}

	@GetMapping("/company/batchOwner/{batchOwner}/owner/{owner}")
	ResponseEntity<List<Company>> getByBatchOwnerAndCompanyOwner(@PathVariable String batchOwner,
			@PathVariable String owner) {
		List<Company> companyList = companyService.getByBatchOwnerAndCompanyOwner(batchOwner, owner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get  by  Batch Owner and Company Owner");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}

	@GetMapping("/company/batchStartDate/{batchStartDate}/companyName/{companyName}")
	ResponseEntity<List<Company>> getByBatchStartDateAndCompanyName(@PathVariable LocalDateTime batchStartDate,
			@PathVariable String companyName) {
		List<Company> companyList = companyService.getByBatchStartDateAndCompanyName(batchStartDate, companyName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Batch StartDate and Company Name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}

	@GetMapping("/company/courseName/{courseName}/companyName/{companyName}")
	ResponseEntity<List<Company>> getByCourseNameAndCompanyName(@PathVariable String courseName,
			@PathVariable String companyName) {
		List<Company> companyList = companyService.getByCourseNameAndCompanyName(courseName, companyName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get CourseName and Company Name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}

	@GetMapping("/company/status/{status}/companyName/{companyName}")
	ResponseEntity<List<Company>> getByCourseStatusAndCompanyName(@PathVariable PostStatus status,
			@PathVariable String companyName) {
		List<Company> companyList = companyService.getByCourseStatusAndCompanyName(status, companyName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Company Name and Status");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}

	@GetMapping("/company/courseStartDate/{courseStartDate}/status/{status}")
	ResponseEntity<List<Company>> getByCourseStartDateAndCompanyStatus(@PathVariable LocalDateTime courseStartDate,
			@PathVariable String status) {
		List<Company> companyList = companyService.getByCourseStartDateAndCompanyStatus(courseStartDate, status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get  StartDate and Status");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(companyList);

	}
	
	@PostMapping("/batches/addbatch/{companyId}")
	ResponseEntity<Batch> addBatch(@RequestBody Batch batch,@PathVariable int  companyId) {
		ResponseEntity<Batch> batchNew=companyService.addBatch(batch,companyId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Batch added");
		Batch batchRes=batchNew.getBody();
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(batchRes);
	}

	@PutMapping("/batches")
	ResponseEntity<Batch> updateBatch(@RequestBody Batch batch) {
		companyService.updateBatch(batch);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping("/batches/batchId/{batchId}")
        ResponseEntity<String> deleteBatch(@PathVariable("batchId") int batchId) {
		companyService.deleteBatch(batchId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}

	@GetMapping("/batches")
	public ResponseEntity<List<Batch>> getAllBatch() {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get All Batches");
		headers.add("info","Returning All Batches");
		List<Batch> batchList=companyService.getAllBatch();
		return ResponseEntity.ok().headers(headers).body(batchList);
	}

	@GetMapping("/batches/{batchId}")
	ResponseEntity<Batch> getByBatchId(@PathVariable("batchId") int batchId) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Id");
		headers.add("info","Returning Batche By Id");
	    Batch batch= companyService.getByBatchId(batchId);
	    return ResponseEntity.ok().headers(headers).body(batch);

	}

	@GetMapping("/batches/batchName/{batchName}")
	ResponseEntity<Batch> getByBatchName(@PathVariable("batchName") String batchName) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By BatchName");
		headers.add("info","Returning Batche By BatchName");
		 Batch batch= companyService.getByBatchName(batchName);
		 return ResponseEntity.ok().headers(headers).body(batch);

	}

	@GetMapping("/batches/owner/{owner}")
	ResponseEntity<List<Batch>> getBybatchOwner(@PathVariable("owner") String owner) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Owner");
		headers.add("info","Returning Batche By Owner");
		List<Batch> batchList= companyService.getBybatchOwner(owner);
		 return ResponseEntity.ok().headers(headers).body(batchList);
		
	}

	@GetMapping("/batches/startDate/{startDate}/endDate/{endDate}")
	ResponseEntity<List<Batch>> batchgetByStartDateAndEndDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Start Date And End Date");
		headers.add("info","Returning Batchs By Start Date And End Date");
		List<Batch> batchList= companyService.getBybatchStartDateAndEndDate(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
		 return ResponseEntity.ok().headers(headers).body(batchList);
	}

	@GetMapping("/batches/status/{status}")
	ResponseEntity<List<Batch>>getBybatchStatus(@PathVariable("status") PostStatus status) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Status");
		headers.add("info","Returning Batchs By Status");
		List<Batch> batchList=  companyService.getBybacthStatus(status);
		 return ResponseEntity.ok().headers(headers).body(batchList);
	}

	@GetMapping("/batches/priority/{priority}")
	ResponseEntity<List<Batch>> getbatchByPriority(@PathVariable("priority") PostPriority priority) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Get Batches By Priority");
		headers.add("info","Returning Batchs By Priority");
		List<Batch> batchList=  companyService.getBybatchPriority(priority);
		return ResponseEntity.ok().headers(headers).body(batchList);
	}
  
	
	
}
