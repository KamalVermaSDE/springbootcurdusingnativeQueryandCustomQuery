package com.springbootcurdoperationusingjpa.service;

import java.util.List;

import com.springbootcurdoperationusingjpa.dto.InstructorRequest;
import com.springbootcurdoperationusingjpa.model.Instructor;

public interface InstructorService {
	
	Instructor getInstructorById(long id);
	
	public Instructor UpdateInstructor(InstructorRequest instructorRequst,long id );
	
	public List<Instructor> getInstructorByFirstName(String firstName);
	
	//List<Instructor> getPaginated(long limit);

}
