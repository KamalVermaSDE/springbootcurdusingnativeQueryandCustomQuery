package com.springbootcurdoperationusingjpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcurdoperationusingjpa.dto.InstructorRequest;
import com.springbootcurdoperationusingjpa.dto.PagingRequest;
import com.springbootcurdoperationusingjpa.model.Instructor;
import com.springbootcurdoperationusingjpa.repository.InstructorRepository;
import com.springbootcurdoperationusingjpa.service.InstructorServiceImpl;

@RestController
@RequestMapping("/ab")
public class InstructorController {

	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private InstructorServiceImpl instructorServiceImpl;
	
	
	@GetMapping("/instructors/firstname/{firstName}")
	public List<Instructor> getInstructorByFirstName(@PathVariable String firstName) {
		return instructorServiceImpl.getInstructorByFirstName(firstName);
	}
	
	@GetMapping("/instructors/lastname/{lastName}")
	public List<Instructor> getInstructorByLastName(@PathVariable String lastName) {
		return instructorRepository.findByName(lastName);
	}

	@GetMapping("/instructors")
	public List<Instructor> getInstructors() {
		return instructorRepository.findAll();
	}
	
	@PostMapping("/instructors/listPageable")
	Page<Instructor> instructorPageable(@RequestBody PagingRequest pagingrequest) {
		Pageable pageable = PageRequest.of(pagingrequest.getSize(), pagingrequest.getPage());
		return instructorRepository.findAll(pageable);
	}
	@GetMapping("/instructors/{id}")
	public Instructor getInstructorById(@PathVariable long id) {
		return instructorServiceImpl.getInstructorById(id);
	}

	@PostMapping("/instructors")
	public Instructor createInstructor(@Valid @RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@PutMapping("/instructors/{id}")
	public Instructor updateUser(@RequestBody InstructorRequest instructorRequest, @PathVariable long id) {
		return instructorServiceImpl.UpdateInstructor(instructorRequest, id);
	}
	@DeleteMapping("/instructors/{id}")
	public void deleteInstructorById(long id) {
		
		instructorRepository.deleteById(id);
		
	}

}
