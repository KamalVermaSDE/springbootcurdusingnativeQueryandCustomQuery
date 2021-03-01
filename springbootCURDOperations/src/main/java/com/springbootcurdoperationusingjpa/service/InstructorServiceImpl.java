package com.springbootcurdoperationusingjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcurdoperationusingjpa.dto.InstructorRequest;
import com.springbootcurdoperationusingjpa.model.Instructor;
import com.springbootcurdoperationusingjpa.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public Instructor getInstructorById(long id) {
		return instructorRepository.getInstructorById(id);
	 	
	}
    
	@Override
	public List<Instructor> getInstructorByFirstName(String firstName) {
		
		return instructorRepository.getInstructorByFirstName(firstName);
	}
	@Override
	public Instructor UpdateInstructor(InstructorRequest instructorRequst, long id) {
		Instructor instructor= new Instructor();
		instructor.setId(instructorRequst.getId());
		instructor.setFirstName(instructorRequst.getFirst_name());
		instructor.setLastName(instructorRequst.getLast_name());
		instructor.setEmail(instructorRequst.getEmail());
		instructorRepository.save(instructor);
		return instructor;
		
	}
}
