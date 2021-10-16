package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import com.learnearn.model.PostAvailability;
import com.learnearn.model.PostStatus;
import com.learnearn.model.Trainer;

public interface ITrainerService {

	List<Trainer> getAll();

	Trainer getById(int trainerId);

	List<Trainer> getByTrainerAvailability(PostAvailability availability);

	List<Trainer> getByTrainerName(String trainerName);

	List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName);

	List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability);

	List<Trainer> getByOwnerAndTrainerName(String courseOwner, String trainerName);

	List<Trainer> getByCourseStartDateAndAvailability(LocalDateTime courseStartDate, PostAvailability availability);

	List<Trainer> getByCourseStatusAndTrainerName(PostStatus status, String trainerName);
	
	//assign
	
	List<Trainer> viewTrainer();
	
	Trainer assignTrainer(int courseId, int trainerId);
	
	Trainer deAssignTrainer(int courseId,int trainerId);
	

}
