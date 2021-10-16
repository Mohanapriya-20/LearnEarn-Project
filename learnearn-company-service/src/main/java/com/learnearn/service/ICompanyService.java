package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.learnearn.model.Batch;
import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

public interface ICompanyService {

	Company addCompany(Company company);

	Company updateCompany(Company company);

	String deleteCompany(int companyId);

	Company getById(int companyId);

	List<Company> getAll();

	List<Company> getByCompanyName(String companyName);

	Company getByOwner(String owner);

	List<Company> getByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);

	List<Company> getByPriority(PostPriority priority);

	List<Company> getByStatus(PostStatus status);

	List<Company> getByBatchNameAndCompanyName(String batchName, String companyName);

	List<Company> getByBatchNameAndCompanyOwner(String batchName, String owner);

	List<Company> getByBatchOwnerAndCompanyPriority(String batchName, PostPriority priority);

	List<Company> getByBatchOwnerAndCompanyOwner(String batchOwner, String owner);

	List<Company> getByBatchStartDateAndCompanyName(LocalDateTime startDate, String companyName);

	List<Company> getByCourseNameAndCompanyName(String courseName, String companyName);

	List<Company> getByCourseStatusAndCompanyName(PostStatus status, String companyName);

	List<Company> getByCourseStartDateAndCompanyStatus(LocalDateTime courseStartDate, String status);
	ResponseEntity<Batch> addBatch(Batch batch,int companyId);

	void updateBatch(Batch batch);

	void deleteBatch(int batchId);
	List<Batch> getAllBatch();

	Batch getByBatchId(int batchId);

	Batch getByBatchName(String batchName);

	List<Batch> getBybatchOwner(String owner);

	List<Batch> getBybatchStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate);

	List<Batch> getBybacthStatus( PostStatus status);

	List<Batch> getBybatchPriority(PostPriority priority);

	List<Batch> getByBatchNameCourseName(String batchName);
	
	List<Batch> getByBatchNameCourseStatus(String batchName,PostStatus status);
	
	List<Batch> getByBatchNameCoursePriority(String batchName,PostPriority priority);
	
	List<Batch> getByBatchNameCourseStartDate(String batchName,LocalDateTime startDate);
	
	List<Batch> getByBatchNameCourseOwner(String batchName,String owner);
}
