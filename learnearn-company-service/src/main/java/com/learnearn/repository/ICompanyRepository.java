package com.learnearn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {

	List<Company> findByCompanyName(String companyName);

	Company findByOwner(String owner);

	List<Company> findByStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate);

	List<Company> findByPriority(PostPriority priority);

	List<Company> findByStatus(PostStatus status);

	@Query("from Company c inner join c.batchList b where b.batchName=?1 and c.companyName=?2")
	List<Company> findByBatchNameAndCompanyName(String batchName,String companyName);

	@Query("from Company c inner join c.batchList b where b.batchName= ?1 and c.owner=?2")
	List<Company> findByBatchNameAndCompanyOwner(String batchName,String owner);
	
		@Query("from Company c inner join c.batchList  b where b.owner= ?1 and c.priority=?2")
	List<Company> findByBatchOwnerAndCompanyPriority(String batchOwner,PostPriority priority );
	
	@Query("from Company c inner join c.batchList b where b.owner= ?1 and c.owner=?2")
	List<Company> findByBatchOwnerAndCompanyOwner(String batchOwner,String owner);
	
	@Query("from Company c inner join c.batchList b where b.startDate= ?1 and c.companyName=?2")
	List<Company> findByBatchStartDateAndCompanyName(LocalDateTime batchStartDate,String companyName);

	
	
	@Query("from Company c inner join c.courseList cs where cs.courseName= ?1 and c.companyName=?2")
	List<Company> findByCourseNameAndCompanyName(String courseName,  String companyName);
	
	@Query("from Company c inner join c.courseList cs where cs.status= ?1 and c.companyName=?2")
	List<Company> findByCourseStatusAndCompanyName(PostStatus status,String companyName);
	
	
	@Query("from Company c inner join c.courseList cs where cs.startDate= ?1 and c.status=?2")
	List<Company> findByCourseStartDateAndCompanyStatus(LocalDateTime courseStartDate,String status);
	


}