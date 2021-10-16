package com.learnearn.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnearn.model.PostAvailability;
import com.learnearn.model.PostStatus;
import com.learnearn.model.Trainer;
import com.learnearn.repository.ITrainerRepository;

@Service
public class ITrianerServiceImpl implements ITrainerService{
	
	@Autowired
	ITrainerRepository trainerRepository;

	@Override
	public List<Trainer> getAll() {
		return trainerRepository.findAll();
	}

	@Override
	public Trainer getById(int trainerId) {
		return trainerRepository.findById(trainerId).get();
	}

	@Override
	public List<Trainer> getByTrainerAvailability(PostAvailability availability) {
		return trainerRepository.findByAvailability(availability);
	}

	@Override
	public List<Trainer> getByTrainerName(String trainerName) {
		return trainerRepository.findByTrainerName(trainerName);
	}


	@Override
	public List<Trainer> getByCourseNameAndTrainerName(String courseName, String trainerName) {
		return trainerRepository.findByCourseNameAndTrainerName(courseName, trainerName);
	}

	@Override
	public List<Trainer> getByCourseNameAndAvailability(String courseName, PostAvailability availability) {
		return trainerRepository.findByCourseNameAndAvailability(courseName, availability);
	}

	@Override
	public List<Trainer> getByOwnerAndTrainerName(String courseOwner, String trainerName) {
		return trainerRepository.findByOwnerAndTrainerName(courseOwner, trainerName);
	}

	@Override
	public List<Trainer> getByCourseStartDateAndAvailability(LocalDateTime courseStartDate,
			PostAvailability availability) {
		return trainerRepository.findByCourseStartDateAndAvailability(courseStartDate, availability);
	}

	@Override
	public List<Trainer> getByCourseStatusAndTrainerName(PostStatus status, String trainerName) {
		return trainerRepository.findByOwnerAndTrainerName(trainerName, trainerName);
	}

	@Override
	public List<Trainer> viewTrainer() {
		return trainerRepository.findAll();
	}

	@Override
	public Trainer assignTrainer(int courseId, int trainerId) {
			
		return trainerRepository.assignTrainer(courseId, trainerId);
	}

	@Override
	public Trainer deAssignTrainer(int courseId,int trainerId) {
		return trainerRepository.deAssignTrainer(courseId, trainerId);
	}

	

}
