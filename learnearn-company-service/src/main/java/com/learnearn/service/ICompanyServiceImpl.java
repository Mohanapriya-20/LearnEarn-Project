package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learnearn.exception.BatchNotFoundException;
import com.learnearn.exception.CompanyNotFoundException;
import com.learnearn.exception.IdNotFoundException;
import com.learnearn.model.Batch;
import com.learnearn.model.Company;
import com.learnearn.model.PostPriority;
import com.learnearn.model.PostStatus;
import com.learnearn.repository.ICompanyRepository;

@Service
public class ICompanyServiceImpl implements ICompanyService {

	@Autowired
	ICompanyRepository companyRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String BASEURL="http://localhost:8082/batch-service/batches";
	List<Batch> bacthList= new ArrayList<>();

	@Override
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Company company) {
		return companyRepository.save(company);

	}

	@Override
	public String deleteCompany(int companyId) {
		 companyRepository.deleteById(companyId);
		 return "deleted Successfully";
	}
	@Override
	public Company getByOwner(String owner) throws CompanyNotFoundException{
		Company company=  companyRepository.findByOwner(owner);
		if(company==null) {
			throw new CompanyNotFoundException("Company Owner Not Found");
		}
		return company;
	}

	@Override
	public Company getById(int companyId) throws IdNotFoundException{
		return companyRepository.findById(companyId).orElseThrow(()->new CompanyNotFoundException("Dude!! Enter Correct Id "));
	}

	@Override
	public List<Company> getAll() {
		 List<Company> companyList= companyRepository.findAll();
		
		 return companyList;
	}

	@Override
	public List<Company> getByCompanyName(String companyName) {
		 List<Company> companyList= companyRepository.findByCompanyName(companyName);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Sorry Company Name is No Where!!!");
		 return companyList;
		
	}

	

	@Override
	public List<Company> getByStartDateAndEndDate(LocalDateTime startDate,LocalDateTime endDate) {
		 List<Company> companyList= companyRepository.findByStartDateAndEndDate(startDate, endDate);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

	@Override
	public List<Company> getByPriority(PostPriority priority) {
		 List<Company> companyList= companyRepository.findByPriority(priority);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

	@Override
	public List<Company> getByStatus(PostStatus status) {
		 List<Company> companyList= companyRepository.findByStatus(status);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

	

	@Override
	public List<Company> getByBatchNameAndCompanyName(String batchName, String companyName) {
		 List<Company> companyList= companyRepository.findByBatchNameAndCompanyName(batchName, companyName);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}
//
	@Override
	public List<Company> getByBatchNameAndCompanyOwner(String batchName, String owner) {
	
		 List<Company> companyList= companyRepository.findByBatchNameAndCompanyOwner(batchName, owner);
	 if(companyList.isEmpty())
		 throw new CompanyNotFoundException("Company Not Found");
	 return companyList;
	}

	@Override
	public List<Company> getByBatchOwnerAndCompanyPriority(String batchName, PostPriority priority) {
		 List<Company> companyList= companyRepository.findByBatchOwnerAndCompanyPriority(batchName, priority);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

@Override
	public List<Company> getByCourseNameAndCompanyName(String courseName, String companyName) {
	 List<Company> companyList=companyRepository.findByCourseNameAndCompanyName(courseName, companyName);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

	@Override
	public List<Company> getByCourseStatusAndCompanyName(PostStatus status, String companyName) {
		 List<Company> companyList= companyRepository.findByCourseStatusAndCompanyName(status, companyName);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

	@Override
	public List<Company> getByBatchOwnerAndCompanyOwner(String batchOwner, String owner) {
		
		 List<Company> companyList= companyRepository.findByBatchOwnerAndCompanyOwner(batchOwner,owner) ;
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
		 
	}

	@Override
	public List<Company> getByBatchStartDateAndCompanyName(LocalDateTime startDate, String companyName) {
	 List<Company> companyList=companyRepository.findByBatchNameAndCompanyName(companyName, companyName);
	 if(companyList.isEmpty())
		 throw new CompanyNotFoundException("Company Not Found");
	 return companyList;
	}

	@Override
	public List<Company> getByCourseStartDateAndCompanyStatus(LocalDateTime courseStartDate, String status) {
		List<Company> companyList=companyRepository.findByCourseStartDateAndCompanyStatus(courseStartDate, status);
		 if(companyList.isEmpty())
			 throw new CompanyNotFoundException("Company Not Found");
		 return companyList;
	}

	@Override
	public ResponseEntity<Batch> addBatch(Batch batch,int companyId) {
		String url=BASEURL+"/addbatch/"+companyId; 
		ResponseEntity<Batch> batchObj = restTemplate.postForEntity(url,batch, Batch.class);
		return batchObj;
	}

	@Override
	public void updateBatch(Batch batch) {
		String url=BASEURL;
		restTemplate.postForEntity(url,batch,Batch.class);
		
		
	}

	@Override
	public void deleteBatch(int batchId) {
		String url=BASEURL+"/batchId/"+batchId;
				Batch batchObj = restTemplate.getForObject(url,Batch.class);
		
		
	}

	@Override
	public List<Batch> getAllBatch() {
		String url=BASEURL ;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}

	@Override
	public Batch getByBatchId(int batchId)  throws IdNotFoundException{
		String url=BASEURL+"/"+batchId;
	ResponseEntity<Batch> batch=restTemplate.getForEntity(url,Batch.class);
		return batch.getBody();
	}

	@Override
	public Batch getByBatchName(String batchName) throws BatchNotFoundException{
		String url=BASEURL+"/batchName/"+batchName;
		ResponseEntity<Batch> batch	=restTemplate.getForEntity(url,Batch.class);
		if(batch==null) {
			throw new IdNotFoundException("Bacth Name  Not here!!!!");
		}
		
		return batch.getBody();
	}

	@Override
	public List<Batch> getBybatchOwner(String owner) throws BatchNotFoundException{
		String url=BASEURL+"/owner/"+owner;
	ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}

	@Override
	public List<Batch> getBybatchStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) throws BatchNotFoundException{
		String url=BASEURL+"/startDate/"+startDate+"/endDate/"+endDate;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}

	@Override
	public List<Batch> getBybacthStatus(PostStatus status) throws BatchNotFoundException{
		String url=BASEURL+"/status/"+status;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}

	@Override
	public List<Batch> getBybatchPriority(PostPriority priority) throws BatchNotFoundException {
		String url=BASEURL+"/priority/"+priority;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		

		return batchList.getBody();
	}	

	@Override
	public List<Batch> getByBatchNameCourseName(String batchName) throws BatchNotFoundException{
		String url=BASEURL+"/batchName/"+batchName;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}

	@Override
	public List<Batch> getByBatchNameCourseStatus(String batchName, PostStatus status) throws BatchNotFoundException {
		String url=BASEURL+"/batchName/"+batchName+"/status/"+status;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		return batchList.getBody();
		
	}

	@Override
	public List<Batch> getByBatchNameCoursePriority(String batchName, PostPriority priority) throws BatchNotFoundException{
		String url=BASEURL+"/batchName/"+batchName+"/priority/"+priority;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}

	@Override
	public List<Batch> getByBatchNameCourseStartDate(String batchName, LocalDateTime startDate) throws BatchNotFoundException{
		String url=BASEURL+"/batchName/"+batchName+"/startDate/"+startDate;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
	
		return batchList.getBody();
	}

	@Override
	public List<Batch> getByBatchNameCourseOwner(String batchName, String owner) throws BatchNotFoundException{
		
		String url=BASEURL+"/batchName/"+batchName+"/owner/"+owner;
		ResponseEntity<List> batchList = restTemplate.getForEntity(url, List.class);
		
		return batchList.getBody();
	}
	


}
